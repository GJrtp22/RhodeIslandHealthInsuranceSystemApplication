package rhis.ms.ed.entity;

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
public class IncomeDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer incomeId;
	private Double monthlySalaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="case_id")
	private Long caseNumber;

}
