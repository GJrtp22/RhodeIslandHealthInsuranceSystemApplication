package rhis.ms.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import rhis.ms.ed.entity.CoTriggersEntity;

public interface CoTriggersRepo extends JpaRepository<CoTriggersEntity, Serializable> {

}
