package com.sshidlovsky.toolforrunners.linkenums;

public enum LinksFeatureRequest {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    REPOSITORY_URL("https://api.github.com"),
    ADD_NEW_ISSUE_URL("/repos/SergeyShidlovsky/toolForRunners/issues"),
    ADD_ISSUE_TO_BOARD_URL("/projects/columns/8414334/cards"),
    ACCESS_TOKEN("efc7e9698d30abe9637b9c0967fe7c5147f75aac"),
    TITLE("Assign an issue on board"),
    DESCRIPTION("Created by tooolforrunners And Assigned to a board"),
    LABEL("Bug"),
    CONTENT_TYPE("Issue");

    private final String value;

    private LinksFeatureRequest(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
