package rhis.ms.dc.service;

import org.springframework.stereotype.Service;

import rhis.ms.dc.bindings.DataCollectionSummary;
import rhis.ms.dc.bindings.Education;
import rhis.ms.dc.bindings.Income;
import rhis.ms.dc.bindings.KidsInfo;
import rhis.ms.dc.bindings.PlanSelection;
import rhis.ms.dc.entity.EducationDataEntity;
import rhis.ms.dc.entity.IncomeDataEntity;
import rhis.ms.dc.entity.PlanSelectionEntity;


@Service
public interface DataCollectionService {
	
	public PlanSelection generateCaseNumberByAppId(Long appId);
	
	public Long updateCitizenPlan(PlanSelection planSelection);
	
	Long saveIncomeDetails(Income income);
	
	Long saveEducationDetails(Education education);
	
	DataCollectionSummary saveKidsDetails(KidsInfo kidsInfo);
	
	 
	
	
	
	
	
	
	
	
	

}
