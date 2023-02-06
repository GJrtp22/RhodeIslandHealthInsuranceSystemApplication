package rhis.ms.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.dc.entity.RegistrationCitizenEntity;

public interface CitizenRepo  extends JpaRepository<RegistrationCitizenEntity, Serializable>{

}
