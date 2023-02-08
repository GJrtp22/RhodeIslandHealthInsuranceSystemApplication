package rhis.ms.ed.service;


import rhis.ms.ed.bindings.EligibilityDetails;

public interface EligibilityDetailsService {
	
	EligibilityDetails checkEligibility(Long caseNumber);
	
	void saveTriggerDetails(Long caseNumber);

}
