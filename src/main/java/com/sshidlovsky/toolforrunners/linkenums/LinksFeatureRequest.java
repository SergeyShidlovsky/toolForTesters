package com.sshidlovsky.toolforrunners.linkenums;

public enum LinksFeatureRequest {

    //ToDo https://github.com/SergeyShidlovsky/toolForTesters/issues/76
    REPOSITORY_URL("https://api.github.com/repos/SergeyShidlovsky/toolForRunners/issues"),
    ACCESS_TOKEN("98023a1a550a1a58e57edeed58de08613184694c"),
    TITLE("Test tittle"),
    DESCRIPTION("Created by tooolforrunners"),
    LABEL("Bug");

    private final String value;

    private LinksFeatureRequest(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
