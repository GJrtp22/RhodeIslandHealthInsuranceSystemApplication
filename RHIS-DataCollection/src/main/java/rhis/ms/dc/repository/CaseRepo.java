package rhis.ms.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.dc.entity.Case;

public interface CaseRepo extends JpaRepository<Case, Long> {

}
