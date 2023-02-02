package rhis.ms.dc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rhis.ms.dc.entity.Case;
import rhis.ms.dc.fiegnclientcommunication.ARClient;
import rhis.ms.dc.repository.CaseRepo;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {
	
	@Autowired
	private ARClient arClient;
	
	@Autowired
	private CaseRepo caseRepo;

	@Override
	public Long generateCaseNumberByAppId(Long appId) {
		
		Long citizenAppId = arClient.invokeSearchAppId(appId);
		if(appId==citizenAppId)
		{
			Case caseRecord = new Case();
			caseRecord.setAppId(appId);
			caseRepo.save(caseRecord);
			
			return caseRecord.getCaseNumber();
			
			
		}
		
		return null;
	}

}
