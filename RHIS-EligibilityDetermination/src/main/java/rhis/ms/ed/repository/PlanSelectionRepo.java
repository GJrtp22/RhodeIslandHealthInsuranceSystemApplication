package rhis.ms.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import rhis.ms.ed.entity.PlanSelectionEntity;

public interface PlanSelectionRepo extends JpaRepository<PlanSelectionEntity, Serializable> {
	
	PlanSelectionEntity findByCaseNumber(Long caseNumber);
	
		
	
	
	
	
	
}
