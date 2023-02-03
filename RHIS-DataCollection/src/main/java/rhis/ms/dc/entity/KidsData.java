package rhis.ms.dc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class KidsData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer kidsId;
	private String kidName;
	private Integer kidAge;
	private Long kidSsn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="case_id")
	private Case caseNumber;

}
