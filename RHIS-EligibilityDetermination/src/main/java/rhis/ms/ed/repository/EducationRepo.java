package rhis.ms.ed.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import rhis.ms.ed.entity.EducationDataEntity;

public interface EducationRepo extends JpaRepository<EducationDataEntity, Integer>{
	
	public EducationDataEntity findByCaseNumber(Long caseNumber);

}
