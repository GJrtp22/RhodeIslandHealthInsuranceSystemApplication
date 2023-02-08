package rhis.ms.ed.entity;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CO_TRIGGERS")
public class CoTriggersEntity {
	
	private Long coTriggerId;
	private Long caseNumber;
	private File coPdf;
	private String triggerStatus;

}
