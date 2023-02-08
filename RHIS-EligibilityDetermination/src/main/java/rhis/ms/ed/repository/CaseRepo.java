package rhis.ms.ed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.ed.entity.CaseEntity;

public interface CaseRepo extends JpaRepository<CaseEntity, Long> {

}
