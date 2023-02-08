package rhis.ms.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rhis.ms.ed.bindings.EligibilityDetails;
import rhis.ms.ed.service.EligibilityDetailsService;

@RestController
public class EligibilityDeterminationController {
	
	@Autowired
	private EligibilityDetailsService eligibilityDetailsService;
	
	@GetMapping("/eligibilityCheck")
	public ResponseEntity<EligibilityDetails> checkEligibility(@PathVariable Long caseNumber)
	{
		EligibilityDetails details = eligibilityDetailsService.checkEligibility(caseNumber);
		return new ResponseEntity<EligibilityDetails>(details, HttpStatus.OK);
		
		
		
	}

}
