package com.sshidlovsky.toolforrunners.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sshidlovsky.toolforrunners.linkenums.LinksFeatureRequest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FeatureRequestOps {

    private Client client;
    private ObjectMapper mapper;
    private WebResource webResource;
    private ClientResponse response;
    private MultivaluedMap<String, String> labels;
    private Map<String, String> titleAndDescription;
    private Map<String, String> addIssueToBoardPayload;

    public FeatureRequestOps() {
        mapper = new ObjectMapper();
        labels = new MultivaluedMapImpl();
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        titleAndDescription = new HashMap();
        addIssueToBoardPayload = new HashMap<String, String>();
    }

    public int createIssue() throws IOException, RuntimeException {
        //Adding webresource by URL
        webResource = createWebResource(LinksFeatureRequest.ADD_NEW_ISSUE_URL.getValue());

        //Adding data to maps that will be used for request payload creation
        titleAndDescription.put("title", LinksFeatureRequest.TITLE.getValue());
        titleAndDescription.put("body", LinksFeatureRequest.DESCRIPTION.getValue());
        labels.add("labels", LinksFeatureRequest.LABEL.getValue());

        //Creating string with request payload
        String firstNode = mapper.writeValueAsString(titleAndDescription);
        String secondNode = mapper.writeValueAsString(labels);
        String requestBody = firstNode.substring(0, firstNode.length() - 1) + "," + secondNode.substring(1);

        log.info("Request " + requestBody);

        //Creating an issue using POST request
        response = response = doPostRequest(webResource, requestBody);

        //Extracting issueId from response payload if there are no errors
        if (response.getStatus() == 201) {
            //toDo: Implement ResponseEntity class to keep result of createIssue request
            String responseBody = response.getEntity(String.class);
            log.info("Response " + responseBody);

            //Parsing the response to get issueId
            int firstIndexOfId = responseBody.indexOf("\",\"id\":") + 7;
            int lastIndexOfId = responseBody.indexOf(",\"node_id\":\"");
            int issueId = Integer.parseInt(responseBody.substring(firstIndexOfId, lastIndexOfId));
            log.info("Issue with IssueId = " + issueId + " has been created");

            return issueId;
        } else {
            //Handling an error if issue wasn't created
            handleErrorFromResponse(response);

            return 0;
        }
    }

    public void assignIssueToProject(int issueId) throws IOException {
        //Adding webresource by URL
        webResource = createWebResource(LinksFeatureRequest.ADD_ISSUE_TO_BOARD_URL.getValue());

        //Adding data to maps that will be used for request payload creation
        addIssueToBoardPayload.put("content_id", Integer.toString(issueId));
        addIssueToBoardPayload.put("content_type", LinksFeatureRequest.CONTENT_TYPE.getValue());
        String requestPayload = mapper.writeValueAsString(addIssueToBoardPayload)
                .replace("\"" + issueId + "\"", " " + issueId);

        log.info("Request: " + requestPayload);

        //Assigning an issue to the board using POST request
        response = doPostRequest(webResource, requestPayload);

        //toDo: Implement ResponseEntity class to keep result of assignIssueToProject request
        log.info("Response " + response.getEntity(String.class));

        //toDo Add code block of successful issue assignment
        //Handling an error if issue wasn't assigned
        handleErrorFromResponse(response);
    }

    private void handleErrorFromResponse(ClientResponse response) {
        if (response.getStatus() != 201) {
            log.error("Failed : HTTP error code : " + response.getStatus());
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus() + "\n" + response.getEntity(String.class));
        }
    }

    private WebResource createWebResource(String resourceLink) {
        webResource = client
                .resource(UriBuilder.fromUri(LinksFeatureRequest.REPOSITORY_URL.getValue() +
                        resourceLink).build());

        return webResource;
    }

    private ClientResponse doPostRequest(WebResource webResource, String requestPayload) {
        response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Accept", "application/vnd.github.inertia-preview+json")
                .header("Authorization", "token " + LinksFeatureRequest.ACCESS_TOKEN.getValue())
                .post(ClientResponse.class, requestPayload);

        return response;
    }


    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/168
    public static void main(String[] args) throws IOException {
        FeatureRequestOps z = new FeatureRequestOps();
        int issueId = z.createIssue();
        z.assignIssueToProject(issueId);
    }
}