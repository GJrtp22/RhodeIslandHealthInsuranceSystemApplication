package rhis.ms.dc.bindings;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanSelection {
	
	private Long caseNumber;
	private Long planId;
	
	private Map<Integer, String> plansInfo;	

}
