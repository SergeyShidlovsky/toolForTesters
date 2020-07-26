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

        WebResource webResource = client
                .resource(UriBuilder.fromUri(LinksFeatureRequest.REPOSITORY_URL.getValue() +
                        LinksFeatureRequest.ADD_NEW_ISSUE_URL.getValue()).build());

        titleAndDescription.put("title", LinksFeatureRequest.TITLE.getValue());
        titleAndDescription.put("body", LinksFeatureRequest.DESCRIPTION.getValue());
        labels.add("labels", LinksFeatureRequest.LABEL.getValue());

        String firstNode = mapper.writeValueAsString(titleAndDescription);
        String secondNode = mapper.writeValueAsString(labels);
        String requestBody = firstNode.substring(0, firstNode.length() - 1) + "," + secondNode.substring(1);

        log.info( "Request " + requestBody);

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", "token " + LinksFeatureRequest.ACCESS_TOKEN.getValue())
                .post(ClientResponse.class, requestBody);

        //toDo: Implement ResponceEntity class to keep result of createIssue request
        String responseBody = response.getEntity(String.class);
        log.info("Response " + responseBody);

        int firstIndexOfId = responseBody.indexOf("\",\"id\":" ) + 7;
        int lastIndexOfId = responseBody.indexOf(",\"node_id\":\"");
        int issueId = Integer.parseInt(responseBody.substring(firstIndexOfId, lastIndexOfId));
        log.info("Issue with IssueId = " + issueId + " has been created");


        if (response.getStatus() != 201) {
            log.error("Failed : HTTP error code : " + response.getStatus());
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return issueId;
    }

    public void assignIssueToProject(int issueaId) throws IOException {
        WebResource webResource = client
                .resource(UriBuilder.fromUri(LinksFeatureRequest.REPOSITORY_URL.getValue() +
                        LinksFeatureRequest.ADD_ISSUE_TO_BOARD_URL.getValue()).build());

        addIssueToBoardPayload.put("content_id", Integer.toString(issueaId));
        addIssueToBoardPayload.put("content_type", LinksFeatureRequest.CONTENT_TYPE.getValue());
        String requestPayload = mapper.writeValueAsString(addIssueToBoardPayload)
                .replace("\"" + issueaId + "\"", " " + issueaId);

        log.info("Request: " + requestPayload);

        ClientResponse response = webResource
                .header("Accept", "application/vnd.github.inertia-preview+json")
                .header("Authorization", "token " + LinksFeatureRequest.ACCESS_TOKEN.getValue())
                .post(ClientResponse.class, requestPayload);

        //toDo: Implement ResponceEntity class to keep result of assignIssueToProject request
        log.info("Response " + response.getEntity(String.class));

        if (response.getStatus() != 201) {
            log.error("Failed : HTTP error code : " + response.getStatus());
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
    }

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/168
    public static void main(String[] args) throws IOException {
        FeatureRequestOps z = new FeatureRequestOps();
        int issueId = z.createIssue();
        z.assignIssueToProject(issueId);
    }
}