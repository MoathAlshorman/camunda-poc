package com.warba.ws.camunda.rest;

import com.warba.ws.camunda.client.CamundaEngineRestClient;
import com.warba.ws.camunda.client.request.MessageRequest;
import com.warba.ws.camunda.client.request.ProcessVariable;
import com.warba.ws.camunda.service.PendingTrxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/maker-checker")
public class MakerCheckerRestController {

    private final PendingTrxService pendingTrxService;
    private final CamundaEngineRestClient camundaEngineRestClient;

    public MakerCheckerRestController(final PendingTrxService pendingTrxService,
            final CamundaEngineRestClient camundaEngineRestClient) {
        this.pendingTrxService = pendingTrxService;
        this.camundaEngineRestClient = camundaEngineRestClient;
    }

    @PostMapping("/submission")
    public ResponseEntity<String> submitContent(@RequestBody String content) {

        final String businessKey = pendingTrxService.saveContent(content);
        camundaEngineRestClient.sendMessage(new MessageRequest("dataSubmitted", businessKey,
                Map.of("content", new ProcessVariable(content, "String"))));
        return ResponseEntity.ok(businessKey);
    }

    @GetMapping("/pending")
    public ResponseEntity<Map<String, String>> getPendingContentTrx() {
        return ResponseEntity.ok(pendingTrxService.findAllContent());
    }

    @PostMapping("/approve/{key}")
    public void approveContent(@PathVariable String key, @RequestBody String comment) {

        pendingTrxService.deleteContent(key);
        camundaEngineRestClient.sendMessage(new MessageRequest("dataReviewed", key,
                Map.of("approved", new ProcessVariable("true", "Boolean")
                , "comment", new ProcessVariable(comment, "String"))));
    }

    @PostMapping("/reject/{key}")
    public void rejectContent(@PathVariable String key, @RequestBody String comment) {

        pendingTrxService.deleteContent(key);
        camundaEngineRestClient.sendMessage(new MessageRequest("dataReviewed", key,
                Map.of("approved", new ProcessVariable("false", "Boolean"), 
                        "comment", new ProcessVariable(comment, "String"))));
    }
}
