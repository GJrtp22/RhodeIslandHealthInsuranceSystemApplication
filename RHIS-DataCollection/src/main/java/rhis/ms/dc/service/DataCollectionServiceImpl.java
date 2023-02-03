package rhis.ms.dc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rhis.ms.dc.bindings.DataCollectionSummary;
import rhis.ms.dc.entity.Case;
import rhis.ms.dc.entity.EducationData;
import rhis.ms.dc.entity.IncomeData;
import rhis.ms.dc.entity.KidsData;
import rhis.ms.dc.entity.PlanSelection;
import rhis.ms.dc.fiegnclientcommunication.ARClient;
import rhis.ms.dc.repository.CaseRepo;
import rhis.ms.dc.repository.EducationRepo;
import rhis.ms.dc.repository.IncomeRepo;
import rhis.ms.dc.repository.KidsRepo;
import rhis.ms.dc.repository.PlanSelectionRepo;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	private ARClient arClient;

	@Autowired
	private CaseRepo caseRepo;

	@Autowired
	private PlanSelectionRepo planSelectionRepo;
	
	@Autowired
	private IncomeRepo incomeRepo;
	@Autowired
	private EducationRepo educationRepo;
	@Autowired
	private KidsRepo kidsRepo;

	@Override
	public Long generateCaseNumberByAppId(Long appId) {

		Long citizenAppId = arClient.invokeSearchAppId(appId);
		if (appId == citizenAppId) {
			Case caseRecord = new Case();
			caseRecord.setAppId(appId);
			caseRepo.save(caseRecord);

			return caseRecord.getCaseNumber();

		}

		return null;
	}

	@Override
	public boolean savePlanDetails(PlanSelection planSelection) {

		PlanSelection save = planSelectionRepo.save(planSelection);
		if (null != save) {
			return true;
		}
		return false;

	}

	@Override
	public boolean saveIncomeDetails(IncomeData incomeData) {
		
		IncomeData save = incomeRepo.save(incomeData);
		if(null!=save)
		{
			return true;
		}

		return false;
		
	}

	@Override
	public boolean saveEducationDetails(EducationData educationData) {
		EducationData save = educationRepo.save(educationData);
		if(null!=save)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean saveKidsDetails(KidsData kidsData) {
		KidsData save = kidsRepo.save(kidsData);
		if(null!=save)
		{
			return true;
		}
		return false;
	}

	@Override
	public DataCollectionSummary getAllDetails(Long caseNumber) {
		
		DataCollectionSummary dataCollectionSummary=new DataCollectionSummary();
		
		
		
		
		
		return null;
	}

	

}
