package rhis.ms.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import rhis.ms.dc.entity.IncomeData;

public interface IncomeRepo extends JpaRepository<IncomeData, Integer> {
	
	
	public IncomeData findByCaseNumber(Long caseNumber);

}
