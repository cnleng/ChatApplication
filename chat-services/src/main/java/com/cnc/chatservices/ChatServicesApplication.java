package com.cnc.chatservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cnc.*" })
public class ChatServicesApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(ChatServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChatServicesApplication.class, args);
	}

}
