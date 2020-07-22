package com.warba.ws.camunda.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//The service layer, could save data to JPA repo.
@Service
public class PendingTrxService {

    private final Map<String, String> allContentTrx = new HashMap<>();

    public String saveContent(String content) {
        final String key = UUID.randomUUID().toString();
        allContentTrx.put(key, content);
        return key;
    }

    public Map<String, String> findAllContent() {
        return allContentTrx;
    }

    public void deleteContent(String key) {
        allContentTrx.remove(key);
    }
}
