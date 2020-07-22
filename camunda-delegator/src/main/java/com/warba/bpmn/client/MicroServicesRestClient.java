package com.warba.bpmn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Customers api's client.
 *
 * @author moath.alshorman
 */
@FeignClient(name = "camunda-engine", url = "http://localhost:8081", configuration =
        FeignClientConfig.class)
public interface MicroServicesRestClient {

    @PostMapping(value = "/publisher/")
    ResponseEntity<String> publish(@RequestBody String content);

    @PostMapping(value = "/mail")
    ResponseEntity<String> sendMail(@RequestBody String content);
}
