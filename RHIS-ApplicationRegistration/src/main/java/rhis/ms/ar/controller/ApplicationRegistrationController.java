package rhis.ms.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rhis.ms.ar.bindings.Citizen;

import rhis.ms.ar.service.ApplicationRegistrationService;

@RestController
public class ApplicationRegistrationController {

	@Autowired
	private ApplicationRegistrationService applicationRegistrationService;

	@PostMapping("/citizenRegistration")
	public ResponseEntity<String> registerCitizen(@RequestBody Citizen citizen) {
		return new ResponseEntity<>(applicationRegistrationService.registerCitizen(citizen), HttpStatus.OK);

	}

}
