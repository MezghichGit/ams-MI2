package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/providers")
@Slf4j
public class ProviderController {
	
	@Autowired
	ProviderService providerService;
	
	@PostMapping("/")
	Provider saveProvider(@RequestBody Provider provider)
	{
		log.info("Ajout avec succès du Provider depuis ProviderController");
		return providerService.addProvider(provider);
	}
	
	@GetMapping("/")
	List<Provider> getAllProviders()
	{
		log.info("Récupération avec succès de tous les providers depuis ProviderController");
		return providerService.getAllProviders();
	}
	
	@GetMapping("/{id}")
	Provider findProviderById(@PathVariable("id") long id)
	{
		log.info("Recherche du Provider avec succès depuis ProviderController");
		return providerService.findProviderById(id);
	}


}
