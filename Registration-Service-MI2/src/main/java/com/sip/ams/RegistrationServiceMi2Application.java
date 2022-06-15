package com.sip.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationServiceMi2Application {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceMi2Application.class, args);
	}

}
