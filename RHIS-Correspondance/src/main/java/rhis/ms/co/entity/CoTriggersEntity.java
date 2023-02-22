package rhis.ms.co.entity;

import java.io.File;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CO_TRIGGERS")
public class CoTriggersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long coTriggerId;
	private Long caseNumber;
	@Lob
	private byte[] coPdf;
	private String triggerStatus;

}
