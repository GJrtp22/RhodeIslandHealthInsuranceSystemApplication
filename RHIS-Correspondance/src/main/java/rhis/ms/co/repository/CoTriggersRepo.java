package rhis.ms.co.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.co.entity.CoTriggersEntity;

public interface CoTriggersRepo extends JpaRepository<CoTriggersEntity, Serializable> {
	
	List<CoTriggersEntity> findByTriggerStatus(String triggerStatus);
	
	CoTriggersEntity findBycaseNumber(Long caseNumber);

	
}
