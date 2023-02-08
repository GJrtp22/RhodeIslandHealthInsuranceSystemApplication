package rhis.ms.ed.bindings;

import java.io.File;

import lombok.Data;

@Data
public class CoTriggers {
	
	private Long caseNumber;
	private File coPdf;
	private String triggerStatus;

}
