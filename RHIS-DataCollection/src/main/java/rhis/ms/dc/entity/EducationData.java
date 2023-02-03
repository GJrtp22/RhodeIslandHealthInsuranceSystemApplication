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
public class EducationData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer educationId;
	private String highestDegree;
	private String graduationYear;
	private String universityName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="case_id")
	private Case caseNumber;

}
