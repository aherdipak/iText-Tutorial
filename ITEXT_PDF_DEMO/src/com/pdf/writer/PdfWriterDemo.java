package com.pdf.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfWriterDemo {
	
	static PdfWriterDemo t = new PdfWriterDemo();
	
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		String dest = "/DEEPAK/TRASH_TEMP/test123.pdf";

		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();

		PdfPTable mainTable = new PdfPTable(1);
		mainTable.setWidths(new int[] {1});
		mainTable.setWidthPercentage(100f);
		PdfPCell mCell;

		
		// ZERO
		Font fontTbleTitle = new Font(FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
		mCell = new PdfPCell(new Phrase("(Private and Confidential)",fontTbleTitle));
		mCell.setBorderWidthTop(0);
		mCell.setBorderWidthBottom(0);
		mCell.setBorderWidthRight(0);
		mCell.setBorderWidthLeft(0);
		mCell.setPaddingRight(5);
		mCell.setPaddingBottom(5);
		mCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		mainTable.addCell(mCell);
		
		// FIRST
		mCell = new PdfPCell(t.getFirstTable());
		mainTable.addCell(mCell);

		// TWO
		Font fontPayslip = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		mCell = new PdfPCell(new Phrase("Payslip for the Month of Sep 2018",fontPayslip)); 
		mCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		mCell.setPaddingBottom(5);
		mainTable.addCell(mCell);

		//THREE 
		mCell = new PdfPCell(t.getThreeTable());  
		mainTable.addCell(mCell);
		
		//FOUR
		mCell = new PdfPCell(t.getFourthTable()); 
		mainTable.addCell(mCell);
		
		
		//FIVE
		Font fontNet = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		mCell = new PdfPCell(new Phrase("Net Salary : 45000.00$ (Rs. Forty Five Thousend Three Hundrend Fifty And Zero Paise Only)",fontNet));
		mCell.setPaddingBottom(5);
		mCell.setBorderWidthTop(0);
		mainTable.addCell(mCell);
		
		// LAST
		Font fontTbleBottom = new Font(FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
		mCell = new PdfPCell(new Phrase("\"This is computer generated statement and does not required any signature or stamp\"", fontTbleBottom));
		mCell.setBorderWidthTop(0);
		mCell.setBorderWidthBottom(0);
		mCell.setBorderWidthRight(0);
		mCell.setBorderWidthLeft(0);
		mCell.setPaddingBottom(5);
		mCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		mainTable.addCell(mCell);

		document.add(mainTable);
		document.close();
		System.out.println("SUCCESS...!!!");
	}
	
	// FIRST TABLE 
	public PdfPTable getFirstTable() throws DocumentException, MalformedURLException, IOException {
		PdfPTable table = new PdfPTable(2);
		table.setWidths(new int[] { 2, 6 });
		PdfPCell cell;

		Image img = Image.getInstance("/DEEPAK/TRASH_TEMP/tiger.jpg");
		cell = new PdfPCell(img, true); 
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthRight(0);
		//cell.setPaddingRight(5);
		cell.setPaddingLeft(5);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(5);
		table.addCell(cell);

		cell = new PdfPCell(getCompanyDetailsTable());
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthLeft(0);
		//cell.setRowspan(4);
		table.addCell(cell);
		
		return table;
	}
	
	
	public PdfPTable getCompanyDetailsTable() throws DocumentException {

		PdfPTable table = new PdfPTable(1);
		table.setWidths(new int[] { 1});
		table.setWidthPercentage(100f);
		PdfPCell cell;

		Font fontH1 = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD); 
		cell = new PdfPCell(new Phrase("Dream Software & Systems",fontH1));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthRight(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		Font fontAddr = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
		cell = new PdfPCell(new Phrase("Sai shrushti,kharghar",fontAddr));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthRight(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Navi Mumbai",fontAddr));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthRight(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Mumbai, Maharashtra-410210",fontAddr));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthRight(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		return table;
	}

	
	// THREE 
	public PdfPTable getThreeTable() throws DocumentException {
		PdfPTable table = new PdfPTable(4);
		table.setWidths(new int[] { 3, 4, 3, 2 });
		PdfPCell cell;

		Font font = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

		cell = new PdfPCell(new Phrase("Employee Name",font));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Mr. Deepak Aher",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Payable Dyas",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("30",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Employee Code",font));
		cell.setBorderWidthTop(0);
		cell.setBorderWidthBottom(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("101783",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Paid Days",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("30",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Designation",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Software enginee",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Paid Days- Arrear",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("0",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Department",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Open System",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Joning Date",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("24 Dec 2017",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Bank Name",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("ICICI",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("PAN",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("BLBDSDHB6790B",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Bank Account NUmber",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("102348SD56489283",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Location",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Mumbai",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("Provident Found No",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("KDNHSKA45DS85884432788387",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Grade",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("A3",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		// ----------------------------------

		cell = new PdfPCell(new Phrase("UAN",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("90w9w4049242929",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("ESIC IP",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("322844SS8822884",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);

		return table;
	}
	

	// FOUR 
	public PdfPTable getFourthTable() throws DocumentException {
		PdfPTable table = new PdfPTable(5);
		table.setWidths(new int[] { 4,2,2,2,2});
		PdfPCell cell;
		
		Font fontH = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

		cell = new PdfPCell(new Phrase(""));
		cell.setPaddingBottom(5);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Current Month",fontH));
		cell.setColspan(2);
		cell.setPaddingBottom(5);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("April To Date",fontH));
		cell.setColspan(2);
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		
		cell = new PdfPCell(new Phrase("Head",fontH));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Earning",fontH));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Deduction",fontH));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Earning",fontH));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Deduction",fontH));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		
		Font font = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
		
		cell = new PdfPCell(new Phrase("Basic",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("15000.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("83,250.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		//-----------------------------
		
		cell = new PdfPCell(new Phrase("Basic_A",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("6750.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		//-----------------------------
		
		cell = new PdfPCell(new Phrase("Basic_c",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("15000.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("83,250.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("0.00",font));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		//-----------------------------
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		//-----------------------------

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		 
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		table.addCell(cell);
		
		//-----------------------------
		
		Font fontL = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		
		cell = new PdfPCell(new Phrase("Total",fontL));
		cell.setPaddingBottom(5);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("45000.00",fontL));
		cell.setPaddingBottom(5);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("3000.00",fontL));
		cell.setPaddingBottom(5);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("2540000.00",fontL));
		cell.setPaddingBottom(5);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("30000.00",fontL));
		cell.setPaddingBottom(5);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		return table;
	}
	
}
