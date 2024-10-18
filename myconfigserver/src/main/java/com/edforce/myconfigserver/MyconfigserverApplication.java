package com.edforce.myconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MyconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyconfigserverApplication.class, args);
	}

}
