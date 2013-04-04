package org.halyph.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lowagie.text.Rectangle;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.events.PdfPageEventForwarder;

public class PBASamplePage {

	/**
	 * Inner class to add lines when a paragraph begins and ends.
	 */
	class ParagraphPositions extends PdfPageEventForwarder {

		float x = 0f;
		float y = 0f;
		float w = 0f;
		float h = 0f;

		public void onParagraph(PdfWriter writer, Document pdfDocument,
				float paragraphPosition) {
			float left = pdfDocument.left();
			float right = pdfDocument.right();
			float vertical = paragraphPosition - 8;

			w = right - left;
			x = left;
			h = vertical;
			// drawLine(writer.getDirectContent(), left, right, vertical);
		}

		public void onParagraphEnd(PdfWriter writer, Document pdfDocument,
				float paragraphPosition) {
			float left = pdfDocument.left();
			float right = pdfDocument.right();
			float vertical = paragraphPosition - 5;

			h = h - vertical;
			y = vertical;
			drawLine(writer.getDirectContent(), left, right, vertical);

		}

		public void drawLine(PdfContentByte cb, float x1, float x2,
				float vertical) {
			// System.out.format("x1=%f, x2=%f, y=%f\n", x1, x2, vertical);
			// System.out.format("x=%f, y=%f, w=%f, h=%f\n", x, y, w, h);
			if (false) {
				cb.moveTo(x1, vertical);
				cb.lineTo(x2, vertical);
				cb.stroke();
			}
			drawRectangle(cb);
		}

		public void drawRectangle(PdfContentByte cb) {
			float xr = x - 10;
			float yr = y - 10;
			float wr = w + 10;
			float hr = h + 10;

			System.out.format("Paragraph: x=%f, y=%f, w=%f, h=%f\n", xr, yr,
					wr, hr);
			cb.rectangle(xr, yr, wr, hr);
			cb.stroke();
		}
	}

	class SectionPosition extends PdfPageEventForwarder {

		float x = 0f;
		float y = 0f;
		float w = 0f;
		float h = 0f;

		public void onSection(PdfWriter writer, Document pdfDocument,
                float position, int depth, Paragraph title) {
			float left = pdfDocument.left();
			float right = pdfDocument.right();
			float vertical = position;

			w = right - left;
			x = left;
			h = vertical;
			// drawLine(writer.getDirectContent(), left, right, vertical);
		}

		 public void onSectionEnd(PdfWriter writer, Document pdfDocument,
	                float position) {
			float left = pdfDocument.left();
			float right = pdfDocument.right();
			float vertical = position;

			h = h - vertical;
			y = vertical;
			drawLine(writer.getDirectContent(), left, right, vertical);

		}

		public void drawLine(PdfContentByte cb, float x1, float x2,
				float vertical) {
			// System.out.format("x1=%f, x2=%f, y=%f\n", x1, x2, vertical);
			// System.out.format("x=%f, y=%f, w=%f, h=%f\n", x, y, w, h);
			if (false) {
				cb.moveTo(x1, vertical);
				cb.lineTo(x2, vertical);
				cb.stroke();
			}
			drawRectangle(cb);
		}

		public void drawRectangle(PdfContentByte cb) {
			float xr = x - 15;
			float yr = y - 25;
			float wr = w + 30;
			float hr = h + 30;

			System.out.format("Section: x=%f, y=%f, w=%f, h=%f\n", xr, yr,
					wr, hr);
			cb.saveState();
			cb.setRGBColorStroke(0x00, 0xFF, 0x00);
			cb.rectangle(xr, yr, wr, hr);
			cb.stroke();
			cb.restoreState();
		}
	}

    class GenericTags extends PdfPageEventForwarder {
        
        public void onGenericTag(PdfWriter writer, Document pdfDocument,
                Rectangle rect, String text) {       
        	if ("radio".equals(text)) {            
                renderRadio(writer.getDirectContent(), rect);
            }        
        	if ("check".equals(text)) {            
        		renderCheck(writer.getDirectContent(), rect);
            }
        }
        
        public void renderRadio(PdfContentByte content, Rectangle rect) {
        	
            float x1 = rect.getLeft()-10;
			float y1 = rect.getBottom()-24;
			float x2 = x1+10;
			float y2 = y1-10;
			
			
			content.circle(x1, y1, 5);
//			content.drawRadioField(x1, y1, 10, 10, false);
            content.stroke();
        }
        
        public void renderCheck(PdfContentByte content, Rectangle rect) {
        	float w = 10;
            content.rectangle(rect.getLeft() - 18, rect.getBottom() - 18f,
            				w, w);
            content.stroke();
        }
    }
	
	/**
	 * Creates a PDF document.
	 * 
	 * @param filename
	 *            the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(String filename) throws IOException,
			DocumentException, SQLException {
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(filename));
		writer.setPageEvent(new ParagraphPositions());
		writer.setPageEvent(new SectionPosition());
		writer.setPageEvent(new GenericTags());
		
		document.setPageSize(PageSize.A4);
		document.setMargins(72, 72, 72, 72);
		document.open();
		
		Chapter chapter = null;
		Section section = null;
		for (int i = 1; i < 3; i++) {
			Paragraph par = createParagraph(document, i);
			par.setSpacingAfter(20);
			par.setSpacingBefore(20);
			chapter = new Chapter(i);
			section = chapter.addSection("Q1");
			section.add(par);
			section.add(createParagraphChoice(document, "<i>ASCII85Decode</i> a filter <u>used</u	> to put the stream into 7-bit <a title=\"ASCII\" href=\"/wiki/ASCII\">ASCII</a>"));
			section.add(createParagraphChoice(document, "<b>ASCIIHexDecode</b> similar to ASCII85Decode but less compact"));
			
			document.add(chapter);
	        document.newPage();	
		}
		
		
        // Close        
		document.close();
	}

	private Paragraph createParagraph(Document document, int number)
			throws IOException {
		Paragraph par = new Paragraph();
		Chunk chunk = new Chunk("Question #" + number);
		par.add(chunk);

		HTMLWorker htmlWorker = new HTMLWorker(document);
		String str = "<html><head></head><body>"
				+ "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>"
				+ "<h1>Show your support</h1>"
				+ "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, "
				+ "in personal hardware and software costs to set up test environments, and above all,"
				+ "the huge amounts of time it takes for one person to design and write the actual content."
				+ "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?"
				+ "<p>Donate using PayPal® to real@rgagnon.com."
				+ "<p>Contributions via PayPal are accepted in any amount "
				+ "<P><br><table border='3'><tr><td>Java HowTo<tr>"
				+ "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>"
				+ "<ol><li>Text</li><li>Text 2</li><li>Text 3</li></ol>"
				+ "<p><font size=\"1\"><b>Bold</b> </font><i>Italic </i><font size=\"3\"><u>Underscore </u></font><br></p>"
				+ "</body></html>";
		ArrayList list = htmlWorker.parseToList(new StringReader(str), null);
		for (Object line : list) {
			par.add((Element) line);
		}
		return par;
	}
	
	private Paragraph createParagraphChoice(Document document, String html)
			throws IOException {
		Paragraph par = new Paragraph();

		Chunk ch = new Chunk(" ");
		ch.setGenericTag("radio");
		
		Chunk ch2 = new Chunk(" ");
		ch2.setGenericTag("check");
		
		
		Paragraph pChunk = new Paragraph();
		pChunk.add(ch);
		pChunk.add(ch2);		
		par.add(pChunk);
		
		HTMLWorker htmlWorker = new HTMLWorker(document);
		String str = html;
		ArrayList list = htmlWorker.parseToList(new StringReader(str), null);
		for (Object line : list) {
			par.add((Element) line);
		}
		par.setIndentationLeft(10);
		par.setSpacingAfter(20);
		par.setSpacingBefore(20);
		
		return par;
	}

	/**
	 * @param args
	 * @throws SQLException
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException,
			DocumentException, SQLException {
		final String result = String.format("result/pba%d.pdf",
				System.currentTimeMillis());
		System.out.println("Filename: " + result);

		new PBASamplePage().createPdf(result);
	}
}
