package com.worldunion.dispatcher_helper.data;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CredentialState {
    UNCOMMITTED("1"),SUCCESSFUL("2"), FAILED("3"), DATA_SUCCESSFUL("4"),
    DATA_FAILED("5");

    private final String name;

    CredentialState(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}