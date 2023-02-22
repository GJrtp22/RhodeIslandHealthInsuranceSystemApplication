package rhis.ms.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.co.entity.RegistrationCitizenEntity;

public interface CitizenRepo  extends JpaRepository<RegistrationCitizenEntity, Serializable>{

}
