package rhis.ms.ed.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import rhis.ms.ed.bindings.EligibilityDetails;
import rhis.ms.ed.entity.CaseEntity;
import rhis.ms.ed.entity.CoTriggersEntity;
import rhis.ms.ed.entity.EducationDataEntity;
import rhis.ms.ed.entity.EligibilityDetailsEntity;
import rhis.ms.ed.entity.IncomeDataEntity;
import rhis.ms.ed.entity.KidsDataEntity;
import rhis.ms.ed.entity.PlanSelectionEntity;
import rhis.ms.ed.entity.RegistrationCitizenEntity;
import rhis.ms.ed.repository.CaseRepo;
import rhis.ms.ed.repository.CitizenRepo;
import rhis.ms.ed.repository.CoTriggersRepo;
import rhis.ms.ed.repository.EducationRepo;
import rhis.ms.ed.repository.EligibilityDetailsRepo;
import rhis.ms.ed.repository.IncomeRepo;
import rhis.ms.ed.repository.KidsRepo;
import rhis.ms.ed.repository.PlanSelectionRepo;

public class EligiblityDetailsServiceImpl implements EligibilityDetailsService {

	@Autowired
	private CaseRepo caseRepo;

	@Autowired
	private IncomeRepo incomeRepo;

	@Autowired
	private CitizenRepo citizenRepo;

	@Autowired
	private EducationRepo educationRepo;

	@Autowired
	private KidsRepo kidsRepo;

	@Autowired
	private PlanSelectionRepo planSelectionRepo;

	@Autowired
	private EligibilityDetailsRepo eligibilityDetailsRepo;

	@Autowired
	private CoTriggersRepo triggerRepo;

	@Override
	public EligibilityDetails checkEligibility(Long caseNumber) {

		EligibilityDetails response = new EligibilityDetails();

		Optional<CaseEntity> caseRecord = caseRepo.findById(caseNumber);
		Long appId = caseRecord.get().getAppId();

		Optional<RegistrationCitizenEntity> citizenRecord = citizenRepo.findById(appId);

		PlanSelectionEntity planRecord = planSelectionRepo.findByCaseNumber(caseNumber);
		String planName = planRecord.getPlanName();

		EligibilityDetailsEntity dbEntity = new EligibilityDetailsEntity();

		if ("SNAP".equalsIgnoreCase(planName)) {

			IncomeDataEntity incomeRecord = incomeRepo.findByCaseNumber(caseNumber);
			Double monthlyIncome = incomeRecord.getMonthlySalaryIncome();
			if (monthlyIncome > 300.00) {

				response.setDenailReason("Income is high");

			}

		}

		else if ("CCAP".equalsIgnoreCase(planName)) {

			boolean ageFlag = false;
			String ageBreakerKidName = "";

			IncomeDataEntity incomeRecord = incomeRepo.findByCaseNumber(caseNumber);
			Double totalIncome = incomeRecord.getMonthlySalaryIncome() + incomeRecord.getPropertyIncome()
					+ incomeRecord.getRentIncome();

			List<KidsDataEntity> kidsRecord = kidsRepo.findByCaseNumber(caseNumber);

			int noOfKids = kidsRecord.size();

			if (noOfKids < 0) {

				response.setDenailReason("Kids are not present");

			}

			else if (totalIncome > 300) {

				response.setDenailReason("Income is High");

			} else if (totalIncome <= 300 && noOfKids > 0) {

				for (KidsDataEntity kidsDataEntity : kidsRecord) {
					if (kidsDataEntity.getKidAge() <= 16) {

						ageFlag = true;

					} else {

						ageFlag = false;
						ageBreakerKidName = kidsDataEntity.getKidName();
						break;
					}

				}
			}

			if (ageFlag == false) {

				response.setDenailReason("Kid" + ageBreakerKidName + " age is greater than 16 years");

			}

		} else if ("Medicaid".equalsIgnoreCase(planName)) {

			IncomeDataEntity incomeRecord = incomeRepo.findByCaseNumber(caseNumber);
			Double monthlyInccome = incomeRecord.getMonthlySalaryIncome();
			Double propertyIncome = incomeRecord.getPropertyIncome();
			Double rentalIncome = incomeRecord.getRentIncome();

			if (monthlyInccome > 300) {

				response.setDenailReason("Income is High");

			} else if (propertyIncome > 0) {

				response.setDenailReason("property Income is high ");

			} else if (rentalIncome > 0) {

				response.setDenailReason("Rental Income is high ");
			}

			else if (monthlyInccome > 0 && rentalIncome > 0 && propertyIncome > 0) {

				response.setDenailReason("Monthly and property and Rental Income is high ");
			}

		} else if ("Medicare".equalsIgnoreCase(planName))

		{

			LocalDate dob = citizenRecord.get().getDob();
			LocalDate today = LocalDate.now();
			Period period = Period.between(dob, today);
			int years = period.getYears();
			if (years < 65) {

				response.setDenailReason("Age is below than 65 years old");

			}

		} else if ("RIW".equalsIgnoreCase(planName)) {
			IncomeDataEntity incomeRecord = incomeRepo.findByCaseNumber(caseNumber);
			Double monthlyInccome = incomeRecord.getMonthlySalaryIncome();

			EducationDataEntity educationRecord = educationRepo.findByCaseNumber(caseNumber);
			String highestDegree = educationRecord.getGraduationYear();
			if (monthlyInccome > 0) {

				response.setDenailReason("Monthly income is available");

			} else if (highestDegree == null) {

				response.setDenailReason("You are not graduated");

			}

		}

		response.setPlanName(planName);
		if (response.getDenailReason() != null) {
			response.setPlanStatus("Denied");
		} else {

			response.setPlanStatus("Approved");
			response.setPlanStartDate(LocalDate.now().plusDays(1));
			response.setPlanEndDate(LocalDate.now().plusMonths(3));
			response.setBenefitAmount(350.00);
		}

		dbEntity.setCaseNumber(caseNumber);
		dbEntity.setHoldername(citizenRecord.get().getFullName());
		dbEntity.setHolderSsn(citizenRecord.get().getSsn());
		BeanUtils.copyProperties(response, dbEntity);

		eligibilityDetailsRepo.save(dbEntity);

		saveTriggerDetails(caseNumber);

		return response;

	}

	@Override
	public void saveTriggerDetails(Long caseNumber) {
		CoTriggersEntity triggerEntity = new CoTriggersEntity();
		triggerEntity.setCaseNumber(caseNumber);
		triggerEntity.setTriggerStatus("pending");
		triggerRepo.save(triggerEntity);

	}

}
