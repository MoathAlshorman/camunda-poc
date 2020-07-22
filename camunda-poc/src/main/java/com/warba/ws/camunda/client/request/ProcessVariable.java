package com.warba.ws.camunda.client.request;

public class ProcessVariable {

    private String value;
    private String type;

    public ProcessVariable() {
    }

    public ProcessVariable(final String value, final String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }
}
