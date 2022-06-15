package com.sip.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ArticleServiceMi2Application {

	public static void main(String[] args) {
		SpringApplication.run(ArticleServiceMi2Application.class, args);
	}

	// Appel d'un webservice externe avec l'api RestTemplate
	@Bean
	@LoadBalanced
	public RestTemplate getProviderFromMicroServiceProvider() {
		return new RestTemplate();
	}

}
