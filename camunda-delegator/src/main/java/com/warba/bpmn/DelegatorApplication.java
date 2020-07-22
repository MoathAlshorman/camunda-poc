package com.warba.bpmn;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableProcessApplication
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.warba.bpmn")
public class DelegatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelegatorApplication.class, args);
    }
}
