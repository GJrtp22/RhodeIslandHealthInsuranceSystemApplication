package rhis.ms.ar.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;
import rhis.ms.ar.bindings.Citizen;
import rhis.ms.ar.constants.ApplicationRegistrationConstants;
import rhis.ms.ar.entity.RegistrationCitizenEntity;
import rhis.ms.ar.exception.RhisSsnNotFoundException;
import rhis.ms.ar.repository.RegistrationCitizenRepo;

@Service
public class ApplicationRegistrationServiceImpl implements ApplicationRegistrationService {

	@Autowired
	private RegistrationCitizenRepo registrationCitizenRepo;

	@Override
	public String registerCitizen(Citizen citizen) {

		WebClient client = WebClient.create();

		String stateName = client.get().uri(ApplicationRegistrationConstants.SSAWEBURL, citizen.getSsn()).retrieve()
				.bodyToMono(String.class).block();

		if (ApplicationRegistrationConstants.RHODEISLANDSSN.equalsIgnoreCase(stateName)) {

			RegistrationCitizenEntity entity = new RegistrationCitizenEntity();
			BeanUtils.copyProperties(citizen, entity);
			entity = registrationCitizenRepo.save(entity);
			if (entity != null) {
				return ApplicationRegistrationConstants.ELIGIBLEMESSAGE + entity.getAppId();
			}

		}

		return ApplicationRegistrationConstants.NONELIGIBLEMESSAGE;

	}

	@Override
	public Long searchAppId(Long appId) {
		Optional<RegistrationCitizenEntity> findById = registrationCitizenRepo.findById(appId);
		if (findById.isPresent()) {
			return findById.get().getAppId();
		}

		return null;
	}

}
