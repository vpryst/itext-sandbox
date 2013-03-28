package org.halyph.itext;

import java.io.FileOutputStream;
import java.io.StringReader;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;

public class HtmlToPDFDemo {

	public static void main(String... args) {
		try {
			Document document = new Document(PageSize.LETTER);
			// PdfWriter pdfWriter =
			PdfWriter.getInstance(document, new FileOutputStream(
					"iTextExample_HTML2PDF.pdf"));
			document.open();
			document.addAuthor("Real Gagnon");
			document.addCreator("Real's HowTo");
			document.addSubject("Thanks for your support");
			document.addCreationDate();
			document.addTitle("Please read this");

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
					+ "<P><br><table border='1'><tr><td>Java HowTo<tr>"
					+ "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>"
					+ "<ol><li>&nbsp;Text</li><li>Text 2</li><li>Text 3</li></ol>"
					+ "<p><font size=\"1\"><b>Bold</b> </font><i>Italic </i><font size=\"3\"><u>Underscore </u></font><br></p>"
					+ "</body></html>";
			htmlWorker.parse(new StringReader(str));
			document.close();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}