package rhis.ms.dc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import rhis.ms.dc.entity.EducationData;

public interface EducationRepo extends JpaRepository<EducationData, Integer>{
	
	@Query(" * FROM EducationData where caseNumber=: caseId")
	public EducationData getEduactionDetails(Long caseId);

}
