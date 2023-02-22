package rhis.ms.dc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import rhis.ms.dc.entity.KidsDataEntity;

@Repository
public interface KidsRepo extends JpaRepository<KidsDataEntity, Integer> {
	
	public List<KidsDataEntity>  findByCaseNumber(Long caseNumber);

}
