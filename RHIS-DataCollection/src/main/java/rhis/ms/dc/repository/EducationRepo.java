package rhis.ms.dc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import rhis.ms.dc.entity.EducationDataEntity;

@Repository
public interface EducationRepo extends JpaRepository<EducationDataEntity, Integer>{
	
	public EducationDataEntity findByCaseNumber(Long caseNumber);

}
