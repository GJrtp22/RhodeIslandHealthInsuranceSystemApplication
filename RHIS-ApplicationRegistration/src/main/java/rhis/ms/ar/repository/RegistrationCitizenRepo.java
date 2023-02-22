package rhis.ms.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rhis.ms.ar.entity.RegistrationCitizenEntity;

@Repository
public interface RegistrationCitizenRepo extends JpaRepository<RegistrationCitizenEntity, Long> {

}
