package rhis.ms.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rhis.ms.dc.service.DataCollectionService;

@RestController
public class DataCollectionController {
	
	@Autowired
	private DataCollectionService dataCollectionService;

	
	@GetMapping("/createCase")
	public ResponseEntity<String> generateCaseNumber(@PathVariable Long appId)
	{
		Long caseNumber = dataCollectionService.generateCaseNumberByAppId(appId);
		if(caseNumber!=null)
		{
			return new ResponseEntity<>("Case number generated", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("App Id is not valid", HttpStatus.BAD_REQUEST);
		
	}
}
