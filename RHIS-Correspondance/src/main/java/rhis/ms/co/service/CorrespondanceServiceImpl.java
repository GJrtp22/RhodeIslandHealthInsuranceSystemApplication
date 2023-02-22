package rhis.ms.co.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rhis.ms.co.bindings.TriggerStatusResponse;
import rhis.ms.co.entity.CaseEntity;
import rhis.ms.co.entity.CoTriggersEntity;
import rhis.ms.co.entity.EligibilityDetailsEntity;
import rhis.ms.co.entity.RegistrationCitizenEntity;
import rhis.ms.co.reports.ReportGenerator;
import rhis.ms.co.repository.CaseRepo;
import rhis.ms.co.repository.CitizenRepo;
import rhis.ms.co.repository.CoTriggersRepo;
import rhis.ms.co.repository.EligibilityDetailsRepo;

@Service
public class CorrespondanceServiceImpl implements CorrespondanceService {

	@Autowired
	private CoTriggersRepo coTriggersRepo;

	@Autowired
	private EligibilityDetailsRepo eligibilityDetailsRepo;

	@Autowired
	private CaseRepo caseRepo;

	@Autowired
	private CitizenRepo citizenRepo;

	

	@Override
	public TriggerStatusResponse processPendingRecords() throws Exception {

		Long successCount = 0l;
		Long failureCount = 0l;

		TriggerStatusResponse triggerStatusResponse = new TriggerStatusResponse();

		// fetch all pending triggers
		List<CoTriggersEntity> pendingTriggerRecords = coTriggersRepo.findByTriggerStatus("Pending");

		for (CoTriggersEntity coTriggersEntity : pendingTriggerRecords) {

			try {

				processTrigger(triggerStatusResponse, coTriggersEntity);
				successCount++;
			} catch (Exception e) {
				failureCount++;
			}
		}

		triggerStatusResponse.setProcessedRecords(Long.valueOf(pendingTriggerRecords.size()));
		triggerStatusResponse.setSuccessCount(successCount);
		triggerStatusResponse.setFailureCount(failureCount);

		return triggerStatusResponse;
	}

	public RegistrationCitizenEntity processTrigger(TriggerStatusResponse response, CoTriggersEntity coTriggersEntity)
			throws Exception {
		
		ReportGenerator reportGenerator = new ReportGenerator();
		RegistrationCitizenEntity appEntity = null;

		EligibilityDetailsEntity eligibilyRecords = eligibilityDetailsRepo
				.findByCaseNumber(coTriggersEntity.getCaseNumber());

		Optional<CaseEntity> caseRecord = caseRepo.findById(coTriggersEntity.getCaseNumber());
		if (caseRecord.isPresent()) {
			Long appId = caseRecord.get().getAppId();
			Optional<RegistrationCitizenEntity> citizenRecord = citizenRepo.findById(appId);
			if (citizenRecord.isPresent()) {
				appEntity = citizenRecord.get();
			}
		}

		reportGenerator.generateAndSendPdf(eligibilyRecords, appEntity);

		return appEntity;

	}

	public void updateTrigger(Long caseNumber, File file) throws Exception {

		CoTriggersEntity coEntity = coTriggersRepo.findBycaseNumber(caseNumber);

		byte[] arr = new byte[(byte) file.length()];

		FileInputStream fis = new FileInputStream(file);
		fis.read(arr);

		coEntity.setCoPdf(arr);
		coEntity.setTriggerStatus("Completed");

		coTriggersRepo.save(coEntity);

		fis.close();
	}

}
