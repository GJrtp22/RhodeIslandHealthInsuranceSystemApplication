package rhis.ms.ed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rhis.ms.ed.entity.KidsDataEntity;

public interface KidsRepo extends JpaRepository<KidsDataEntity, Integer> {
	
	public List<KidsDataEntity>  findByCaseNumber(Long caseNumber);

}
