package rhis.ms.co.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.co.entity.EligibilityDetailsEntity;

public interface EligibilityDetailsRepo extends JpaRepository<EligibilityDetailsEntity, Serializable>{
	
	EligibilityDetailsEntity findByCaseNumber(Long caseNumber);

}
