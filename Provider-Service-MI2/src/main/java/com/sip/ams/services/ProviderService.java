package com.sip.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ProviderService {
	@Autowired
	ProviderRepository providerRepository;

	public Provider addProvider(Provider provider) {
		return providerRepository.save(provider);
	}

	public Provider updateProvider(Provider provider) {
		return providerRepository.save(provider);
	}

	public void deleteProvider(Provider provider) {
		providerRepository.delete(provider);
	}

	public long coutProviders() {
		return providerRepository.count();
	}

	public void deleteProviderById(Long id) {
		providerRepository.deleteById(id);
	}

	public List<Provider> getAllProviders() {
		return providerRepository.findAll();
	}

	public Provider findProviderByName(String name) {
		return providerRepository.findProviderByName(name);
	}

	public Provider findProviderByAddress(String address) {
		return providerRepository.findProviderByAddress(address);
	}
	
	public Provider findProviderById(long id) {
		return providerRepository.findProviderById(id);
	}

}
