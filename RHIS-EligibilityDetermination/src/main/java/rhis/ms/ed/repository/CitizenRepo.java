package rhis.ms.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.ed.entity.RegistrationCitizenEntity;

public interface CitizenRepo  extends JpaRepository<RegistrationCitizenEntity, Serializable>{

}
