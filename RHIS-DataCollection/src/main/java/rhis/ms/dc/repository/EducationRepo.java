package rhis.ms.dc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import rhis.ms.dc.entity.EducationData;

public interface EducationRepo extends JpaRepository<EducationData, Integer>{
	
	public EducationData findByCaseNumber(Long caseNumber);

}
