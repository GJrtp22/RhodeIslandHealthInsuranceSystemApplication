package rhis.ms.co.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.co.entity.CaseEntity;

public interface CaseRepo extends JpaRepository<CaseEntity, Long> {

}
