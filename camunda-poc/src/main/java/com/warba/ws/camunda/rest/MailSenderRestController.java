package com.warba.ws.camunda.rest;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/mail")
public class MailSenderRestController {

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestBody String content) {

        log.info("Mail has been sent with this content:" + content);
        return ResponseEntity.ok("Mail has been sent with this content:" + content);
    }
}
