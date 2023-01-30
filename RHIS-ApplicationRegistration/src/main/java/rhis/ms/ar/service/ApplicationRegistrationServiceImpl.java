package rhis.ms.ar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;
import rhis.ms.ar.constants.ApplicationRegistrationConstants;
import rhis.ms.ar.entity.RegistrationCitizen;
import rhis.ms.ar.exception.RhisSsnNotFoundException;
import rhis.ms.ar.repository.RegistrationCitizenRepo;

@Service
public class ApplicationRegistrationServiceImpl implements ApplicationRegistrationService {
	
	@Autowired
	private RegistrationCitizenRepo registrationCitizenRepo;

	@Override
	public String registerCitizen(RegistrationCitizen registrationCitizen) {
		
		String apiUrl=ApplicationRegistrationConstants.SSAWEBURL+registrationCitizen.getSsn().toString();
		
		WebClient client=WebClient.create();
		
		String ssn = client.get().uri(apiUrl).retrieve().bodyToMono(String.class).block();
		
		
		if(ApplicationRegistrationConstants.RHODEISLANDSSN.equalsIgnoreCase(ssn))
		{
			RegistrationCitizen result = registrationCitizenRepo.save(registrationCitizen);
			if(result!=null)
			{
				return ApplicationRegistrationConstants.ELIGIBLEMESSAGE;
			}
					
		}
		
			 return ApplicationRegistrationConstants.NONELIGIBLEMESSAGE; 
		
		
	}

}
