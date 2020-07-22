package com.warba.ws.camunda.client.request;

import java.util.Map;

public class MessageRequest {

    private String messageName;
    private String businessKey;
    private Map<String, ProcessVariable> processVariables;

    public MessageRequest() {
    }

    public MessageRequest(final String messageName, final String businessKey, final Map<String, ProcessVariable> processVariables) {
        this.messageName = messageName;
        this.businessKey = businessKey;
        this.processVariables = processVariables;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(final String messageName) {
        this.messageName = messageName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(final String businessKey) {
        this.businessKey = businessKey;
    }

    public Map<String, ProcessVariable> getProcessVariables() {
        return processVariables;
    }

    public void setProcessVariables(final Map<String, ProcessVariable> processVariables) {
        this.processVariables = processVariables;
    }
}
