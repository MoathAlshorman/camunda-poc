package com.warba.ws.camunda.rest;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/publisher")
public class PublisherRestController {

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody String content) {

        log.info("Published this info:" + content);
        return ResponseEntity.ok("Published this info:" + content);
    }
}
