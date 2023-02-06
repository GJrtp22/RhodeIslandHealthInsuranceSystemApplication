package rhis.ms.dc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rhis.ms.dc.entity.IncomeData;
import rhis.ms.dc.entity.KidsData;

public interface KidsRepo extends JpaRepository<KidsData, Integer> {
	
	public List<KidsData>  findByCaseNumber(Long caseNumber);

}
