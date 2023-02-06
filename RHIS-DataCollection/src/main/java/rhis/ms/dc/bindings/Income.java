package rhis.ms.dc.bindings;

import lombok.Data;

@Data
public class Income {
	
	private Integer incomeId;
	private Double monthlySalaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	private Long caseNumber;

}
