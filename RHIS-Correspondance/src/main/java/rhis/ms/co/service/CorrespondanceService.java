package rhis.ms.co.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import rhis.ms.co.bindings.TriggerStatusResponse;

public interface CorrespondanceService {

	TriggerStatusResponse processPendingRecords() throws DocumentException, IOException, Exception;

	void updateTrigger(Long caseNumber, File file) throws FileNotFoundException, Exception;

}
