package com.warba.ws.camunda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.warba.ws.camunda")
public class CamundaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaPocApplication.class, args);
	}

}
