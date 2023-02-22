package rhis.ms.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rhis.ms.dc.entity.RegistrationCitizenEntity;

@Repository
public interface CitizenRepo  extends JpaRepository<RegistrationCitizenEntity, Serializable>{

}
