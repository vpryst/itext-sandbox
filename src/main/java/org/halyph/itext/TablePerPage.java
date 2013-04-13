/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package org.halyph.itext;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TablePerPage {

    private static final float YY = PageSize.A4.getHeight() - 36;
	/** The resulting PDF file. */
    public static final String RESULT
        = String.format("result/Table%d.pdf", System.currentTimeMillis());;

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        new TablePerPage().createPdf(RESULT);
    }

	private float y;
    
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        
//        ColumnText ct = new ColumnText(writer.getDirectContent());
//        ct.setSimpleColumn(36, 36,PageSize.A4.getWidth() - 36, YY);
        
//        y = ct.getYLine();
//        Element e = null;
//
//        e= createFirstTable();
//        writeColumn(document, ct,e );   
//        
//        e= new Phrase("1     Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam pharetra ante. Phasellus fringilla velit ut odio! Nam nec nulla.\n\n");
//        writeColumn(document, ct,e);       
//                
//        e = new Phrase("2     Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam pharetra ante. Phasellus fringilla velit ut odio! Nam nec nulla.\n\n");
//        writeColumn(document, ct, e);
//        
//        e= new Phrase("3     Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam pharetra ante. Phasellus fringilla velit ut odio! Nam nec nulla.\n\n");
//        writeColumn(document, ct,e );
//
//        e= new Phrase("4     Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam pharetra ante. Phasellus fringilla velit ut odio! Nam nec nulla.\n\n");
//        writeColumn(document, ct,e );

        
//        document.newPage();
//        ct.setYLine( PageSize.A4.getHeight() - 36);
        document.add(createFirstTable());
//        writeColumn(document, ct,e);
        // step 5
        document.close();
    }

	private int writeColumn(Document document, ColumnText ct, Element el)
			throws DocumentException {
		y = ct.getYLine();
		System.out.println("y = " + y);
		ct.addElement(el);
		int status = ct.go(true);
		System.out.println("true   Status = " + status);
		
		if (ColumnText.hasMoreText(status)) {
            document.newPage();
            y =806.0f;      
            
         }
		ct.addElement(el);
		ct.setYLine(y);
		System.out.println("y = " + ct.getYLine());
		
        status = ct.go(false);
        
		System.out.println("false Status = " + status);
		System.out.println();
//		if(status ==2) {
//			ct.setYLine(YY);
//		}
        return status;
	}
    
    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(2);
        table.setSplitRows(true);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("================TAble 11111 Cell with colspan 3"));
        cell.setColspan(2);
//        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
//        cell.setRowspan(2);
        for(int i=0; i< 10; i++) {
        	
//        	table.addCell(new Phrase("4     Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam pharetra ante. Phasellus fringilla velit ut odio! Nam nec nulla.\n\n"));
        	PdfPTable table2 = new PdfPTable(2);
        	table2.addCell("row 1; cell 2");
          table2.addCell("row 2; cell 1");
          table2.addCell("row 2; cell 2");
        	
            cell = new PdfPCell(new Phrase("9990     VestVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam ullaibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam ulla.\n\n"));
        	cell.setColspan(2);
            table.addCell(cell);
            table.addCell(table2);
        }	
        // we add the four remaining cells with addCell()
        
//        table.addCell("row 1; cell 2");
//        table.addCell("row 2; cell 1");
//        table.addCell("row 2; cell 2");
        table.getDefaultCell().setBorder(2);
        
        return table;
    }
}
