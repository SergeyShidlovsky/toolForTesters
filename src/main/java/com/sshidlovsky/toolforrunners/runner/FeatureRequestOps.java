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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FeatureRequestOps {

    private int issueId;
    private Client client;
    private int issueNumber;
    private ObjectMapper mapper;
    private String requestPayload;
    private WebResource webResource;
    private ClientResponse response;
    private MultivaluedMap<String, String> labels;
    private Map<String, String> titleAndDescription;
    private Map<String, String> addIssueToBoardPayload;
    private Map<String, List<String>> assignIssueToUserPayload;

    public FeatureRequestOps() {
        mapper = new ObjectMapper();
        labels = new MultivaluedMapImpl();
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        titleAndDescription = new HashMap<String, String>();
        addIssueToBoardPayload = new HashMap<String, String>();
        assignIssueToUserPayload = new HashMap<String, List<String>>();
    }

    public void createIssue() throws IOException, RuntimeException {
        //Adding webresource by URL
        webResource = createWebResource(LinksFeatureRequest.ADD_NEW_ISSUE_URL.getValue());

        //Adding data to maps that will be used for request payload creation
        //ToDo Use Multivalued map for request response payloads
        titleAndDescription.put("title", LinksFeatureRequest.TITLE.getValue());
        titleAndDescription.put("body", LinksFeatureRequest.DESCRIPTION.getValue());
        labels.add("labels", LinksFeatureRequest.LABEL.getValue());

        //Creating string with request payload
        String firstNode = mapper.writeValueAsString(titleAndDescription);
        String secondNode = mapper.writeValueAsString(labels);
        requestPayload = firstNode.substring(0, firstNode.length() - 1) + "," + secondNode.substring(1);

        log.info("Request " + requestPayload);

        //Creating an issue using POST request
        response = doPostRequest(webResource, requestPayload);

        //Extracting issueId from response payload if there are no errors
        if (response.getStatus() == ClientResponse.Status.CREATED.getStatusCode()) {
            //toDo: Implement ResponseEntity class to keep result of createIssue request
            String responseBody = response.getEntity(String.class);
            log.info("Response " + responseBody);

            //Parsing the response to get issueId
            issueId = parseIdBetweenNodes("\",\"id\":", 7, ",\"node_id\":\"", responseBody);
            log.info("Issue with IssueId = " + issueId + " has been created");

            //Parsing the response to get issueNumber
            issueNumber = parseIdBetweenNodes("\",\"number\":", 11, ",\"title\":\"", responseBody);
            log.info("Issue with IssueId = " + issueId + " has issueNumber = " + issueNumber);

        } else {
            //Handling an error if issue wasn't created
            handleErrorFromResponse(response);
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


    public void assignIssueToUser(int issueNumber) throws IOException, RuntimeException {
        //Adding webresource by URL
        webResource = createWebResource(LinksFeatureRequest.ASSIGN_ISSUE_TO_USER.getValue()
                .replace("//", "/" + issueNumber + "/"));

        //Adding data to maps that will be used for request payload creation
        List<String> assigneeList = new ArrayList<String>();
        assigneeList.add("SergeyShidlovsky");
        assignIssueToUserPayload.put("assignees", assigneeList);
        requestPayload = mapper.writeValueAsString(assignIssueToUserPayload);

        log.info("Request: " + requestPayload);

        //Assigning an issue to user using POST request
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

    //toDo: When  ResponseEntity class to keep result of createIssue request will be implemented delete it
    private int parseIdBetweenNodes(String firstKey, int keySize, String secondKey, String responseBody) {
        int firstIndexOfId = responseBody.indexOf(firstKey) + keySize;
        int lastIndexOfId = responseBody.indexOf(secondKey);

        return  Integer.parseInt(responseBody.substring(firstIndexOfId, lastIndexOfId));
    }

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/168
    public static void main(String[] args) throws IOException {
        FeatureRequestOps z = new FeatureRequestOps();
        z.createIssue();
        z.assignIssueToProject(z.issueId);
        z.assignIssueToUser(z.issueNumber);
    }
}