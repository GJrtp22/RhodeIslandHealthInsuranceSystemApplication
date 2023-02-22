package rhis.ms.ar.service;

import org.springframework.stereotype.Service;

import rhis.ms.ar.bindings.Citizen;


@Service
public interface ApplicationRegistrationService {
	
	String registerCitizen(Citizen citizen);
	
	Long searchAppId(Long appId);

}
