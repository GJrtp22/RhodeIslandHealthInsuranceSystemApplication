package rhis.ms.dc.service;

import rhis.ms.dc.bindings.DataCollectionSummary;
import rhis.ms.dc.entity.EducationData;
import rhis.ms.dc.entity.IncomeData;
import rhis.ms.dc.entity.KidsData;
import rhis.ms.dc.entity.PlanSelection;

public interface DataCollectionService {
	
	Long generateCaseNumberByAppId(Long appId);
	
	boolean savePlanDetails(PlanSelection planSelection);
	
	boolean saveIncomeDetails(IncomeData incomeData);
	
	boolean saveEducationDetails(EducationData educationData);
	
	boolean saveKidsDetails(KidsData kidsData);
	
	DataCollectionSummary getAllDetails(Long caseNumber);
	
	
	
	
	
	
	
	
	

}
