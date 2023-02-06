package rhis.ms.dc.bindings;

import java.util.List;

import lombok.Data;

@Data
public class KidsInfo {
	
	private List<KidData> kidsDetails;
	
	private Long caseNumber;

}
