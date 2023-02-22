package rhis.ms.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import rhis.ms.dc.entity.IncomeDataEntity;

@Repository
public interface IncomeRepo extends JpaRepository<IncomeDataEntity, Integer> {
	
	
	public IncomeDataEntity findByCaseNumber(Long caseNumber);

}
