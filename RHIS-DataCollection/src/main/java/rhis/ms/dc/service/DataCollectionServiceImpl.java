package rhis.ms.dc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import rhis.ms.dc.bindings.PlanSelection;
import org.springframework.stereotype.Service;

import rhis.ms.dc.bindings.DataCollectionSummary;
import rhis.ms.dc.bindings.Education;
import rhis.ms.dc.bindings.Income;
import rhis.ms.dc.bindings.KidData;
import rhis.ms.dc.bindings.KidsInfo;

import rhis.ms.dc.entity.CaseEntity;

import rhis.ms.dc.entity.EducationDataEntity;
import rhis.ms.dc.entity.IncomeDataEntity;
import rhis.ms.dc.entity.KidsDataEntity;
import rhis.ms.dc.entity.PlanSelectionEntity;
import rhis.ms.dc.entity.RegistrationCitizenEntity;
import rhis.ms.dc.fiegnclientcommunication.ARClient;
import rhis.ms.dc.repository.CaseRepo;
import rhis.ms.dc.repository.CitizenRepo;
import rhis.ms.dc.repository.EducationRepo;
import rhis.ms.dc.repository.IncomeRepo;
import rhis.ms.dc.repository.KidsRepo;
import rhis.ms.dc.repository.PlanSelectionRepo;

@Service
public class DataCollectionServiceImpl<incomeRepo> implements DataCollectionService {

	@Autowired
	private ARClient arClient;

	@Autowired
	private CaseRepo caseRepo;
	
	@Autowired
	private CitizenRepo citizenRepo;

	@Autowired
	private PlanSelectionRepo planSelectionRepo;
	
	@Autowired
	private IncomeRepo incomeRepo;
	@Autowired
	private EducationRepo educationRepo;
	@Autowired
	private KidsRepo kidsRepo;
	
	
	@Override
	public PlanSelection generateCaseNumberByAppId(Long appId) {
		
		PlanSelection planSelection=new PlanSelection();
		
		Optional<RegistrationCitizenEntity> findById = citizenRepo.findById(appId);
		if(findById.isPresent())
		{
			//create case
			CaseEntity entity=new CaseEntity();
			entity.setAppId(appId);
			entity = caseRepo.save(entity);
			
			
			//fetch plans data to insert into db
			List<PlanSelectionEntity> plans = planSelectionRepo.findAll();
			Map<Integer, String> planMap=new HashMap<>();
			
			plans.forEach(plan -> {
			planMap.put(plan.getPlanId(), plan.getPlanName());
			});
			
			
			//preparing response..sending case number and plans
			planSelection.setPlansInfo(planMap);
			planSelection.setCaseNumber(entity.getCaseNumber());
			
			
			
			
		}
		
		return planSelection;
	}
	@Override
	public Long updateCitizenPlan(PlanSelection planSelection) {
		Long caseNumber = planSelection.getCaseNumber();
		//Long planId = planSelection.getPlanId();
		
		Optional<CaseEntity> findById = caseRepo.findById(caseNumber);
		if(findById.isPresent())
		{
			CaseEntity caseData = findById.get();
			//caseData.setPlanId(null);
			caseRepo.save(caseData);
		}
		return caseNumber;
	}
	@Override
	public Long saveIncomeDetails(Income income) {
		
		IncomeDataEntity entity=new IncomeDataEntity();
		BeanUtils.copyProperties(income, entity);
		incomeRepo.save(entity);
		return entity.getCaseNumber().getCaseNumber();
	}
	@Override
	public Long saveEducationDetails(Education education) {
		
		EducationDataEntity entity=new EducationDataEntity();
		BeanUtils.copyProperties(education, entity);
		educationRepo.save(entity);
		
		return entity.getCaseNumber().getCaseNumber();
	}
	@Override
	public DataCollectionSummary saveKidsDetails(KidsInfo kidsInfo) {
		Long caseNumber = kidsInfo.getCaseNumber();
		
		List<KidData> kidsDetails = kidsInfo.getKidsDetails();
		
		List<KidsDataEntity> kidsEntities=new ArrayList<>();
		
		kidsDetails.forEach(kid -> {
			KidsDataEntity entity=new KidsDataEntity();
			BeanUtils.copyProperties(kid, entity);
			//entity.setCaseNumber(caseNumber);		
			kidsEntities.add(entity);
		});
		
		kidsRepo.saveAll(kidsEntities);
		
		
		
		
		return  getSummary(caseNumber);
	}
	
	private DataCollectionSummary getSummary(Long caseNumber)
	{
		Optional<CaseEntity> dcCase = caseRepo.findById(caseNumber);
		CaseEntity caseEntity= dcCase.get();
		PlanSelectionEntity planIdRec = caseEntity.getPlanId();
		Long appId = caseEntity.getAppId();
		
		Optional<PlanSelectionEntity> dcPlan = planSelectionRepo.findById(planIdRec.getPlanId());
		String planName = dcPlan.get().getPlanName();
		
		Optional<RegistrationCitizenEntity> citizen = citizenRepo.findById(appId);
		String fullName = citizen.get().getFullName();
		Long ssn = citizen.get().getSsn();
		
		
		
		IncomeDataEntity income = incomeRepo.findByCaseNumber(caseNumber);
		EducationDataEntity education = educationRepo.findByCaseNumber(caseNumber);
		List<KidsDataEntity> kids = kidsRepo.findByCaseNumber(caseNumber);
		
		
		DataCollectionSummary summary=new DataCollectionSummary();
		summary.setFname(fullName);
		summary.setPlanName(planName);
		summary.setSsn(ssn);
		
		Income incomeObj=new Income();
		Education educationObj=new Education();
		KidsInfo kidsObj=new KidsInfo();
		
		BeanUtils.copyProperties(income, incomeObj);
		BeanUtils.copyProperties(education, educationObj);
		BeanUtils.copyProperties(kids, kidsObj);
		
		summary.setEducationInfo(educationObj);
		summary.setIncome(incomeObj);
		summary.setKidsInfo(kidsObj);
		
		
		return summary;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*@Override
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
	
	*/


	

}
