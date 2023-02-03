package rhis.ms.dc.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataCollectionSummary {
	
	private Long caseNumber;
	private String planName;
	private Double monthlySalaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	private String highestDegree;
	private String graduationYear;
	private String universityName;
	private String kidName;
	private Integer kidAge;
	private Long kidSsn;

}
