package com.warba.bpmn;

import com.warba.bpmn.client.MicroServicesRestClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("mailSender")
public class RejectionNotificationDelegate implements JavaDelegate {

    private final MicroServicesRestClient microServicesRestClient;

    public RejectionNotificationDelegate(final MicroServicesRestClient microServicesRestClient) {
        this.microServicesRestClient = microServicesRestClient;
    }

    public void execute(DelegateExecution execution) throws Exception {

        String content = (String) execution.getVariable("content");
        String comment = (String) execution.getVariable("comment");

        microServicesRestClient.sendMail("Rejected Content:" + content + ", Comment:" + comment);
    }

}
