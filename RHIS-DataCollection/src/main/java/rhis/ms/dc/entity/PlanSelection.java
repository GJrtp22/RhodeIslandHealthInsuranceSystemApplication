package rhis.ms.dc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanSelection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	private String planName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="case_id")
	private Case caseNumber;

}
