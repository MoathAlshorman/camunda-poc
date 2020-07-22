package com.warba.bpmn;

import com.warba.bpmn.client.MicroServicesRestClient;
import lombok.extern.java.Log;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Log
@Service("publisher")
public class PublisherDelegate implements JavaDelegate {

    private static int counter;
    private final MicroServicesRestClient microServicesRestClient;

    public PublisherDelegate(final MicroServicesRestClient microServicesRestClient) {
        this.microServicesRestClient = microServicesRestClient;
    }

    public void execute(DelegateExecution execution) throws Exception {

        log.info("Try to publish..");

        if (counter > 2) {
            counter = 0;
            log.info("failed to publish..");
            throw new BpmnError("PublisherError");
        }

        String content = (String) execution.getVariable("content");
        microServicesRestClient.publish(content);
        counter++;
    }
}
