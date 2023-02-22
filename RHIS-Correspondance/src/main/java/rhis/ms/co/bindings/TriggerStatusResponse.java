package rhis.ms.co.bindings;

import lombok.Data;

@Data
public class TriggerStatusResponse {
	
	private Long processedRecords;
	private Long successCount;
	private Long failureCount;

}
