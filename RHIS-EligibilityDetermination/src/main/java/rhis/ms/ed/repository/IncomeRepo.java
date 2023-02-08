package rhis.ms.ed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import rhis.ms.ed.entity.IncomeDataEntity;

public interface IncomeRepo extends JpaRepository<IncomeDataEntity, Integer> {
	
	
	public IncomeDataEntity findByCaseNumber(Long caseNumber);

}
