package rhis.ms.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rhis.ms.dc.entity.IncomeData;
import rhis.ms.dc.entity.KidsData;

public interface KidsRepo extends JpaRepository<KidsData, Integer> {
	
	@Query(" * FROM KidsData where caseNumber=: caseId")
	public KidsData getIncomeDetails(Long caseId);

}
