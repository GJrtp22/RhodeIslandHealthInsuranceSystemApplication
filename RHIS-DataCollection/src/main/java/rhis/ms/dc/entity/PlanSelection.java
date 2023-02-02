package rhis.ms.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanSelection {
	
	@Id
	private Integer planId;
	private Long caseNumber;
	private String planName;

}
