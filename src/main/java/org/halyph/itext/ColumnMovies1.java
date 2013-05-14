/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package org.halyph.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;

public class ColumnMovies1 implements PdfPTableEvent {

    /** The resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter03/column_movies1.pdf";
    /** Path to the resources. */
    public static final String RESOURCE
        = "resources/posters/%s.jpg";
    
    /** Definition of two columns */
//    public static final float[][] COLUMNS = {
//        { 36, 36, 224, 579 } , { 230, 36, 418, 579 },
//        { 424, 36, 612, 579 } , { 618, 36, 806, 579 }
//    };
    
    public static final float[][] COLUMNS = {
        { 36, 36, 579, 806 }
    };
	private int tableNum;
    
    
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
    	// Create a database connection
        // step 1
        Document document = new Document(PageSize.A4);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        ColumnText ct = new ColumnText(writer.getDirectContent());
        int column = 0;
        ct.setSimpleColumn(
            COLUMNS[column][0], COLUMNS[column][1],
            COLUMNS[column][2], COLUMNS[column][3]);
//        ct.setSimpleColumn(36, 36,PageSize.A4.getWidth() - 36, PageSize.A4.getHeight() - 36);
        int status = ColumnText.START_COLUMN;
        float y;
        Image img;
        for (int i=0; i < 120; i++) {
            y = ct.getYLine();            
            PdfPTable table = createFirstTable();
            addContent(ct,  table);            
            status = ct.go(true);
            System.out.println( totalRowHeights(document, writer.getDirectContent(), table));
            if (ColumnText.hasMoreText(status)) {
//                column = (column + 1) % 4;
//                if (column == 0)
                    document.newPage();
//                ct.setSimpleColumn(
//                    COLUMNS[column][0], COLUMNS[column][1],
//                    COLUMNS[column][2], COLUMNS[column][3]);
                y = COLUMNS[column][3];
            }
            ct.setYLine(y);
            ct.setText(null);
            addContent(ct, table);
            status = ct.go();
        }
        // step 5
        document.close();
        // Close the database connection
    }
    
    public static float totalRowHeights(
    		  Document document, PdfContentByte content, 
    		  PdfPTable table) throws DocumentException {
    		  float height = 0f;
    		  ColumnText ct = new ColumnText(content);
    		// respect current Document.PageSize    
    		 int column=0;
    		  ct.setSimpleColumn(
    		            COLUMNS[column][0], COLUMNS[column][1],
    		            COLUMNS[column][2], COLUMNS[column][3]);
    		  ct.addElement(table);
    		// **simulate** adding the PdfPTable to calculate total height
    		  ct.go(true);
    		  
    		  return table.getTotalHeight();
    		}
    
    
    /**
     * Add content to a ColumnText object.
     * @param ct the ColumnText object
     * @param movie a Movie object
     * @param img the poster of the image
     */
    public void addContent(ColumnText ct, PdfPTable  table) {
//        ct.addElement(img);
//        ct.addElement(new Paragraph(movie.getTitle(), FilmFonts.BOLD));
//        if (movie.getOriginalTitle() != null) {
//            ct.addElement(new Paragraph(movie.getOriginalTitle(), FilmFonts.ITALIC));
//        }
//        ct.addElement(PojoToElementFactory.getDirectorList(movie));
//        ct.addElement(PojoToElementFactory.getYearPhrase(movie));
//        ct.addElement(PojoToElementFactory.getDurationPhrase(movie));
//        ct.addElement(PojoToElementFactory.getCountryList(movie));
        ct.addElement(table);
        ct.addElement(Chunk.NEWLINE);
    }
    
	public PdfPTable createFirstTable() {
		// a table with three columns
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		// table.setSplitRows(true);
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase(
				"================ Table 1 Cell with colspan 3"));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		PdfPTable table2 = new PdfPTable(2);
		table.addCell("row 1; cell 1");
		table.addCell("row 1; cell 2");
		table.addCell("row 2; cell 1");
		table.addCell("row 2; cell 2");

		cell = new PdfPCell(
				new Phrase(
						"9990     VestVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam ullaibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eget mi at sem iaculis hendrerit. Nulla facilisi. Etiam sed elit. In viverra dapibus sapien. Aliquam nisi justo, ornare non, ultricies vitae, aliquam sit amet, risus! Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus risus. Vestibulum pretium augue non mi. Sed magna. In hac habitasse platea dictumst. Quisque massa. Etiam viverra diam ulla.\n\n"));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(table2);
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
		int end = (new Random()).nextInt(15);
		for (int i = 0; i < end; i++) {
			table.addCell("row 1; cell 1: " + i);
			table.addCell("row 1; cell 2: " + i);
			table.addCell("row 2; cell 1: " + i);
			table.addCell("row 2; cell 2: " + i);
		}
		
		table.getDefaultCell().setBorder(0);
		table.setTableEvent(this);
		return table;
	}

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, DocumentException, SQLException {
    	final String result = String.format("result/pbaTablePage%d.pdf",
				System.currentTimeMillis());
		System.out.println("Filename: " + result);
    	
    	new ColumnMovies1().createPdf(result);
    }

	public void tableLayout(PdfPTable table, float[][] width, float[] height,
			int headerRows, int rowStart, PdfContentByte[] canvas) {
		 PdfContentByte background = canvas[PdfPTable.BASECANVAS];
         background.saveState();
         background.setCMYKColorFill(0x00, 0x00, 0xFF, 0x0F);
         background.setRGBColorStroke(0x00, 0xFF, 0x00);
         background.rectangle(
             width[0][0], height[height.length - 1],
             width[0][1] - width[0][0], height[0] - height[height.length - 1]);
//         background.fill();
//         background.stroke();
         background.fillStroke();
         background.restoreState();
        tableNum++;
		System.out.format("Table %d, coord[%s, [%s,%s]\n", tableNum, Arrays.toString(width[0]), height[0], height[height.length - 1]);
	}
}
