package rhis.ms.dc.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Data
@ToString
public class DataCollectionSummary {
	
	private String fname;
	private Long ssn;
	private String planName;
	
	private Income income;
	private Education educationInfo;
	private KidsInfo kidsInfo;

}
