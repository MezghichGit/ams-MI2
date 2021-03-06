package com.sip.ams.repositories;
import com.sip.ams.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

	Provider findProviderById(Long id);
	
	Provider findProviderByName(String name);
	
	Provider findProviderByAddress(String address);
}
