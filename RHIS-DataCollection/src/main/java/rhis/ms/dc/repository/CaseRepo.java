package rhis.ms.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import rhis.ms.dc.entity.CaseEntity;

@Repository
public interface CaseRepo extends JpaRepository<CaseEntity, Long> {

}
