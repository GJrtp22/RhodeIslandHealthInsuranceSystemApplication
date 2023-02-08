package rhis.ms.ed.bindings;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class EligibilityDetails {
	
	private Long edTraceId; 
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmount;
	private String denailReason;

}
