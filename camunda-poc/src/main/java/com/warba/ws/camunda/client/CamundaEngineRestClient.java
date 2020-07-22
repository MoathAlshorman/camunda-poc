package com.warba.ws.camunda.client;

import com.warba.ws.camunda.client.request.MessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Customers api's client.
 *
 * @author moath.alshorman
 */
@FeignClient(name = "camunda-engine", url = "http://localhost:8080/engine-rest", configuration =
        FeignClientConfig.class)
public interface CamundaEngineRestClient {

    @GetMapping(value = "/engine/default/process-definition")
    ResponseEntity<String> getDefinedProcesses();

    @PostMapping(value = "/message")
    ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest);
}
