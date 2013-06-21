package org.halyph.itext;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.ex.HTMLWorkerEx;
import com.lowagie.text.pdf.PdfWriter;

public class OIHtmlToPDFDemo {
    public static final String RESULT = String.format("result/iTextExample_HTML2PDF%d.pdf", System.currentTimeMillis());
    
    public static void main(String... args) {
        try {
            Document document = new Document(PageSize.LETTER);
            File pdfFile = File.createTempFile("iTextExample_HTML2PDF", ".pdf");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            GenericTags event = new GenericTags();
            writer.setPageEvent(event);

            document.open();
            document.addAuthor("Real Gagnon");
            document.addCreator("Real's HowTo");
            document.addSubject("Thanks for your support");
            document.addCreationDate();
            document.addTitle("Please read this");

            HTMLWorkerEx htmlWorker = new HTMLWorkerEx(document);
            String str =
//                "<table border='1'><tr>"
//                    +"<td style=\"color: blue\">Javascript HowTo color blue<tr>"
//                    + "<td style=\"font-size: small\">font-size: small<tr>"
//                    + "<td style=\"font-size: large\">font-size: large<tr>"
//                    +"</tr></table>";
                "<span style=\"text-align: center;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic? </span>"
                + "<p style=\"line-height: 10pt\"><span style=\"font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span></p>"
                + "<p style=\"text-align: left\"><span style=\"font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span></p>"
                + "<p style=\"text-align: center\"><span style=\"font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span></p>";
            
            ArrayList list = htmlWorker.parseToList(new StringReader(str), null);
            for (Object line : list) {
                document.add((Element) line);
            }
            document.close();
            System.out.println("Done");
            Desktop.getDesktop().open(pdfFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}