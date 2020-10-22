package com.sshidlovsky.toolforrunners.linkenums;

import java.util.Calendar;
import java.util.Date;

public enum LinksFeatureRequest {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    REPOSITORY_URL("https://api.github.com"),
    ADD_NEW_ISSUE_URL("/repos/SergeyShidlovsky/toolForRunners/issues"),
    ADD_ISSUE_TO_BOARD_URL("/projects/columns/8414334/cards"),
    ASSIGN_ISSUE_TO_USER("/repos/SergeyShidlovsky/toolForRunners/issues//assignees"),
    ACCESS_TOKEN("fcf56238e0135d0cb4f5720671395b69f1080528"),
    TITLE("Assign an issue on board"),
    DESCRIPTION("Created by tooolforrunners And Assigned to a board in " +
            Calendar.getInstance().getTimeInMillis()),
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
