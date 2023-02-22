package rhis.ms.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import rhis.ms.dc.bindings.PlanSelection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rhis.ms.dc.bindings.DataCollectionSummary;
import rhis.ms.dc.bindings.Education;
import rhis.ms.dc.bindings.Income;
import rhis.ms.dc.bindings.KidsInfo;


import rhis.ms.dc.repository.PlanSelectionRepo;
import rhis.ms.dc.service.DataCollectionService;

@RestController
public class DataCollectionController {

	@Autowired
	private DataCollectionService dataCollectionService;

	/*
	 * @GetMapping("/createCase") public ResponseEntity<String>
	 * generateCaseNumber(@PathVariable Long appId, RedirectAttributes
	 * redirectAttrs) { Long caseNumber =
	 * dataCollectionService.generateCaseNumberByAppId(appId); if(null!=caseNumber)
	 * { redirectAttrs.addAttribute("caseid", caseNumber); return new
	 * ResponseEntity<>("redirect:/saveplandata/{caseid}", HttpStatus.OK); }
	 * 
	 * return new ResponseEntity<String>("App Id is not valid",
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @PostMapping("/saveplandata/{caseid}") public ResponseEntity<String>
	 * savePlanDetails(@RequestBody PlanSelection planSelection,
	 * 
	 * @PathVariable(name="caseid") Long caseid, RedirectAttributes
	 * redirectAttributes ) {
	 * 
	 * 
	 * boolean result = dataCollectionService.savePlanDetails(planSelection);
	 * if(result==true) { redirectAttributes.addAttribute("caseid", caseid); return
	 * new ResponseEntity<>("redirect:/saveincomedata/{caseid}", HttpStatus.OK);
	 * 
	 * } return new ResponseEntity<String>
	 * ("Plan selection details are not saved, please try again",
	 * HttpStatus.CONFLICT); }
	 * 
	 * @PostMapping("/saveincomedata/{caseid}") public ResponseEntity<String>
	 * saveIncomeDetails(@RequestBody IncomeData incomeData,
	 * 
	 * @PathVariable(name="caseid") Long caseid, RedirectAttributes
	 * redirectAttributes ) {
	 * 
	 * 
	 * boolean result = dataCollectionService.saveIncomeDetails(incomeData);
	 * if(result==true) { redirectAttributes.addAttribute("caseid", caseid); return
	 * new ResponseEntity<>("redirect:/saveeducationdata/{caseid} ", HttpStatus.OK);
	 * 
	 * } return new
	 * ResponseEntity<String>("Income details are not saved, please try again",
	 * HttpStatus.CONFLICT); }
	 * 
	 * @PostMapping("/saveeducationdata/{caseid}") public ResponseEntity<String>
	 * saveKidsDetails(@RequestBody EducationData eduData,
	 * 
	 * @PathVariable(name="caseid") Long caseid, RedirectAttributes
	 * redirectAttributes) { boolean result =
	 * dataCollectionService.saveEducationDetails(eduData); if(result==true) {
	 * redirectAttributes.addAttribute("caseid", caseid); return new
	 * ResponseEntity<>("redirect:/savekidsdata/{caseid} ", HttpStatus.OK);
	 * 
	 * } return new
	 * ResponseEntity<String>("Education details are not saved, please try again",
	 * HttpStatus.CONFLICT); }
	 * 
	 * @PostMapping("/savekidsdata/{caseid}") public ResponseEntity<String>
	 * saveKidsDetails(@RequestBody KidsData kidsData,
	 * 
	 * @PathVariable(name="caseid") Long caseid, RedirectAttributes
	 * redirectAttributes) { boolean result =
	 * dataCollectionService.saveKidsDetails(kidsData); if(result==true) {
	 * redirectAttributes.addAttribute("caseid", caseid); return new
	 * ResponseEntity<>(" redirect:/summary/{caseid}", HttpStatus.OK);
	 * 
	 * } return new
	 * ResponseEntity<String>("Kids details are not saved, please try again",
	 * HttpStatus.CONFLICT); }
	 * 
	 * 
	 * @GetMapping("/summary/{caseid}") public ResponseEntity<DataCollectionSummary>
	 * getAllDetails(@PathVariable(name="caseid") Long caseid){
	 * 
	 * return new
	 * ResponseEntity<DataCollectionSummary>(dataCollectionService.getAllDetails(
	 * caseid), HttpStatus.OK);
	 * 
	 * 
	 * 
	 * }
	 */

	@GetMapping("/case/{appId}")
	public ResponseEntity<PlanSelection> createCase(@PathVariable Long appId) {
		PlanSelection planSelection = dataCollectionService.generateCaseNumberByAppId(appId);

		return new ResponseEntity<PlanSelection>(planSelection, HttpStatus.OK);

	}
	
	@PostMapping("/applyplan")
	public ResponseEntity<Long> applyPlan(@RequestBody PlanSelection planSelection)
	{
		Long caseNum = dataCollectionService.updateCitizenPlan(planSelection);
		return new ResponseEntity<Long>(caseNum, HttpStatus.OK);
	}
	
	@PostMapping("/saveIncome")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income)
	{
		Long caseNum = dataCollectionService.saveIncomeDetails(income);
		return new ResponseEntity<Long>(caseNum, HttpStatus.OK);
	}
	
	@PostMapping("/saveEducation")
	public ResponseEntity<Long> saveEducation(@RequestBody Education education)
	{
		Long caseNum = dataCollectionService.saveEducationDetails(education);
		return new ResponseEntity<Long>(caseNum, HttpStatus.OK);
	}
	
	@PostMapping("/saveKids")
	public ResponseEntity<DataCollectionSummary> SaveKids(@RequestBody KidsInfo kids)
	{
		DataCollectionSummary summary = dataCollectionService.saveKidsDetails(kids);
		return new ResponseEntity<>(summary, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	

}