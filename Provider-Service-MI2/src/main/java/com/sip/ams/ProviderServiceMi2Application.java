package com.sip.ams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

@SpringBootApplication
@EnableEurekaClient
public class ProviderServiceMi2Application implements CommandLineRunner{

	@Autowired
	ProviderService providerService;
	public static void main(String[] args) {
		SpringApplication.run(ProviderServiceMi2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	List<Provider> providers = Arrays.asList(
			new Provider(null,"Samsung","KOREA"),
			new Provider(null,"HP","USA"),
			new Provider(null,"Toshiba","Japan")
			);
		Stream<Provider> stream = providers.stream();
		stream.forEach(provider ->  providerService.addProvider(provider));
		
		providerService.getAllProviders().forEach(System.out::println);
	}
}
