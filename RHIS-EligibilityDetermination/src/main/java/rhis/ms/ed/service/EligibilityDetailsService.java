package rhis.ms.ed.service;


import org.springframework.stereotype.Service;

import rhis.ms.ed.bindings.EligibilityDetails;

@Service
public interface EligibilityDetailsService {
	
	EligibilityDetails checkEligibility(Long caseNumber);
	
	void saveTriggerDetails(Long caseNumber);

}
