package rhis.ms.co.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import rhis.ms.co.entity.CaseEntity;
import rhis.ms.co.entity.CoTriggersEntity;
import rhis.ms.co.entity.EligibilityDetailsEntity;
import rhis.ms.co.entity.RegistrationCitizenEntity;
import rhis.ms.co.repository.CaseRepo;
import rhis.ms.co.repository.CoTriggersRepo;
import rhis.ms.co.service.CorrespondanceService;
import rhis.ms.co.utils.EmailUtils;

@Component
public class ReportGenerator {
	
	@Autowired
	private CoTriggersRepo coTriggersRepo;
	
	@Autowired
	private CaseRepo caseRepo;
	
	@Autowired
	private CorrespondanceService correspondanceService;
	
	@Autowired
	private EmailUtils emailUtils;
	
	public void generateAndSendPdf(EligibilityDetailsEntity eligibilityDetailsEntity, RegistrationCitizenEntity citizenRecord)
			throws Exception {
		
		Document document = new Document(PageSize.A4);
		
		File file=new File(eligibilityDetailsEntity.getBenefitAmount() + ".pdf");
		
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
		
		PdfWriter pdfWriter = PdfWriter.getInstance(document, fos);

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(BaseColor.BLUE);

		Paragraph p = new Paragraph("Eligibilty Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
		
		/*PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 6.5f, 10.5f, 8.5f, 5.5f, 4.5f, 8.9f});
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		cell.setBackgroundColor(BaseColor.BLUE);
		
		Font cellFont = FontFactory.getFont(FontFactory.HELVETICA);
		cellFont.setColor(BaseColor.WHITE);
		
		cell.setPhrase(new Phrase("Citizen Name", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Name", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Status", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Start Date", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan End Date", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Benefit Amount", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Deniel Reason", cellFont));
		table.addCell(cell);

		table.addCell(citizenRecord.getFullName());
		table.addCell(eligibilityDetailsEntity.getPlanName());
		table.addCell(eligibilityDetailsEntity.getPlanStatus());
		table.addCell(eligibilityDetailsEntity.getPlanStartDate()+ "");
		table.addCell(eligibilityDetailsEntity.getPlanEndDate()+ "");
		table.addCell(eligibilityDetailsEntity.getBenefitAmount()+"");
		table.addCell(eligibilityDetailsEntity.getDenailReason()+"");
		document.add(table);*/
		
		
		
		if("Approved".equalsIgnoreCase(eligibilityDetailsEntity.getPlanStatus()))
		{

		Chunk caseNum = new Chunk("Case Num:" + eligibilityDetailsEntity.getCaseNumber(), font);
		
		Chunk name = new Chunk("Name:" + citizenRecord.getFullName(), font);
		Chunk ssn = new Chunk("SSN:" + citizenRecord.getSsn(), font);
		Chunk planName = new Chunk("Plan Name:" + eligibilityDetailsEntity.getPlanName(), font);
		Chunk planStatus = new Chunk("Plan Status:" + eligibilityDetailsEntity.getPlanStatus(), font);
		
		

		document.add(caseNum);
		document.add( Chunk.NEWLINE );
		document.add(name);
		document.add( Chunk.NEWLINE );
		document.add(ssn);
		document.add( Chunk.NEWLINE );
		document.add(planName);
		document.add( Chunk.NEWLINE );
		document.add(planStatus);
		
		
		}
		else {
			
			Chunk caseNum = new Chunk("Case Num:" + eligibilityDetailsEntity.getCaseNumber(), font);
			Chunk name = new Chunk("Name:" + citizenRecord.getFullName(), font);
			Chunk ssn = new Chunk("SSN:" + citizenRecord.getSsn(), font);
			Chunk planName = new Chunk("Plan Name:" + eligibilityDetailsEntity.getPlanName(), font);
			Chunk denialReason = new Chunk("Denial Reason:" + eligibilityDetailsEntity.getDenailReason(), font);
			
			document.add(caseNum);
			document.add( Chunk.NEWLINE );
			document.add(name);
			document.add( Chunk.NEWLINE );
			document.add(ssn);
			document.add( Chunk.NEWLINE );
			document.add(denialReason);
			
		}
		
		Chunk address = new Chunk("USA", font);
		Chunk contactNum = new Chunk("9090890890", font);
		Chunk website = new Chunk("www.rhis.com", font);
		
		document.add( Chunk.NEWLINE );
		document.add(address);
		document.add( Chunk.NEWLINE );
		document.add(contactNum);
		document.add( Chunk.NEWLINE );
		document.add(website);
		
		document.close();
		
		String subject="HIS Eligibility Info";
		String body="HIS Eligible Info";
		
		//emailUtils.sendEmail(citizenRecord.getEmail(), subject, body, file);
		
		correspondanceService.updateTrigger(eligibilityDetailsEntity.getCaseNumber(), file);
		
		
		
		
		
		file.delete();

		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	




















	public String prepareApprovedNotice(EligibilityDetailsEntity detailsEntity, RegistrationCitizenEntity citizenRecord)
			throws DocumentException, IOException {

		// create document
		Document document = new Document();
		// PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

		// open document
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLUE);

		// create main heading as paragraph sentence
		Paragraph p = new Paragraph("List of Insurance Plan Customers", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		// add paragraph to document
		document.add(p);

		// create table and its styles
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 6.5f, 10.5f, 8.5f, 5.5f, 4.5f, 8.9f, 8.5f });
		table.setSpacingBefore(10);

		// create cell and its styles
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		cell.setBackgroundColor(BaseColor.BLUE);

		Font cellFont = FontFactory.getFont(FontFactory.HELVETICA);
		cellFont.setColor(BaseColor.WHITE);
		cellFont.setSize(12);

		// add table headers
		cell.setPhrase(new Phrase("ID", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("NAME", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("EMAIL", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PHONE NUMBER", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("GENDER", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SSN", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PLAN NAME", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PLAN STATUS", cellFont));
		table.addCell(cell);

		// add table data
		/*
		 * for () { table.addCell(String.valueOf(entry.getCustomerId()));
		 * table.addCell(entry.getCustomerName());
		 * table.addCell(entry.getCustomerEmail());
		 * table.addCell(entry.getCustomerPhoneNumber());
		 * table.addCell(entry.getCustomerGender());
		 * table.addCell(String.valueOf(entry.getCustomerSSN()));
		 * table.addCell(entry.getPlanName()); table.addCell(entry.getPlanStatus()); }
		 */
		// add table to document
		document.add(table);
		document.close();

		return "Successfully downloaded";
	}

}
