package org.halyph.itext;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.ex.ExHTMLWorker;
import com.lowagie.text.pdf.PdfWriter;

public class HtmlToPDFDemo {
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

            ExHTMLWorker htmlWorker = new ExHTMLWorker(document);
            String str =
                "<html><head></head><body>" + "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>"
                    + "<h1>VP Test - Show your support</h1>"
                    + "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, "
                    + "in personal hardware and software costs to set up test environments, and above all,"
                    + "the huge amounts of time it takes for one person to design and write the actual content."
                    + "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?"
                    + "<p>Donate using PayPal® to real@rgagnon.com." + "<p>Contributions via PayPal are accepted in any amount "
                    + "<P><br><table border='1'><tr><td>Java HowTo<tr>" + "<td bgcolor='red'>Javascript HowTo<tr>"
                    + "<td bgcolor='red'>Javascript HowTo <tr>" + "<td bgcolor='blue'>Javascript HowTo<tr>"
                    + "<td bgcolor='#000000'>Javascript HowTo<tr>" + "<td bgcolor='#ff9900'>Javascript HowTo<tr>"
                    + "<td bgcolor='rgb(255,255,255)'>Javascript HowTo<tr>" + "<td bgcolor='rgb(255,255,255)'>Javascript HowTo<tr>"
                    + "<td bgcolor='transparent'>Javascript HowTo<tr>" + "<td style=\"background-color: red\">background-color: red<tr>"
                    + "<td style=\"background-color: blue; text-align: left\">background-color: blue<tr>"
                    + "<td style=\"background-color: #000000; text-align: center\">background-color: #000000<tr>"
                    + "<td style=\"background-color: #ff9900; text-align: right\">background-color: #ff9900<tr>"
                    + "<td style=\"background-color: rgb(255,255,255)\">background-color: rgb(255,255,255)<tr>"
                    + "<td style=\"background-color: rgb(255,130,255)\">background-color: rgb(255,130,255)<tr>"
                    + "<td style=\"background-color: transparent\">background-color: transparent<tr>"
                    + "<td style=\"color: red\">Javascript HowTo color red<tr>"
                    + "<td style=\"color: blue\">Javascript HowTo color blue<tr>"
                    + "<td style=\"color: #FF00F0\">Javascript HowTo color #000000<tr>"
                    + "<td style=\"color: #ff9900\">Javascript HowTo color #ff9900<tr>"
                    + "<td style=\"color: rgb(255,255,255)\">Javascript HowTo color rgb(255,255,255)<tr>"
                    + "<td style=\"color: rgb(255,130,255)\">Javascript HowTo color rgb(255,130,255)<tr>"
                    + "<td style=\"color: transparent\">Javascript HowTo color transparent<tr>"
                    + "<td style=\"display: inline\">display: inline<tr>" + "<td style=\"display: block\">display: block<tr>"
                    + "<td style=\"display: list-item\">display: list-item<tr>" + "<td style=\"display: none\">display: none<tr>"
                    + "<td style=\"font-family: Georgia\">font-family: Georgia<tr>"
                    + "<td style=\"font-family: Palatino Linotype\">font-family: Palatino Linotype<tr>"
                    + "<td style=\"font-family: Book Antiqua\">font-family: Book Antiqua<tr>"
                    + "<td style=\"font-family: Times New Roman\">font-family: Times New Roman<tr>"
                    + "<td style=\"font-family: Arial\">font-family: Arial<tr>"
                    + "<td style=\"font-family: Helvetica\">font-family: Helvetica<tr>"
                    + "<td style=\"font-family: Arial Black\">font-family: Arial Black<tr>"
                    + "<td style=\"font-family: Impact\">font-family: Impact<tr>"
                    + "<td style=\"font-family: Lucida Sans Unicode\">font-family: Lucida Sans Unicode<tr>"
                    + "<td style=\"font-family: Tahoma\">font-family: Tahoma<tr>"
                    + "<td style=\"font-family: Verdana\">font-family: Verdana<tr>"
                    + "<td style=\"font-family: Courier New\">font-family: Courier New<tr>"
                    + "<td style=\"font-family: Lucida Console\">font-family: Lucida Console<tr>"
                    + "<td style=\"font-size: xx-small\">font-size: xx-small<tr>"
                    + "<td style=\"font-size: x-small\">font-size: x-small<tr>"
                    + "<td style=\"font-size: small\">font-size: small<tr>"
                    + "<td style=\"font-size: medium\">font-size: medium<tr>"
                    + "<td style=\"font-size: large\">font-size: large<tr>"
                    + "<td style=\"font-size: x-large\">font-size: x-large<tr>"
                    + "<td style=\"font-size: xx-large\">font-size: xx-large<tr>"
                    + "<td style=\"font-size: smaller\">font-size: smaller<tr>"
                    + "<td style=\"font-size: larger\">font-size: larger<tr>"
                    + "<td style=\"font-size: 10px\">font-size: 10px<tr>"
                    + "<td style=\"font-size: 20px\">font-size: 20px<tr>"
                    + "<td style=\"font-size: 50%\">font-size: 50%<tr>"
                    + "<td style=\"font-size: 150%\">font-size: 150%<tr>"
                    +

                    "<td style=\"color: red\">Javascript HowTo<tr>"
                    + "<td style=\"color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + "<td style=\"background-color: red\">Javascript HowTo<tr>"
                    + ""
                    + "<td>Powerbuilder HowTo</table>"
                    + "<ol><li>&nbsp;Text</li><li>Text 2</li><li>Text 3</li></ol>"
                    // +
                    // "<p style=\"font-style: italic\"><font size=\"1\" ><b>Bold</b> </font><i>Italic </i><font size=\"3\"><u>Underscore </u></font><br></p>"
                    +"<span style=\"font-size: xx-small;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span>"
                    /*
                     * +
                     * "<span style=\"font-size: xx-small;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span>"
                     * +x
                     * "<span style=\"font-size: xx-small;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span>"
                     * +
                     * "<span style=\"font-size: xx-small;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span>"
                     */
                    + "<p style=\"background-color:red\">1 </p> " + "<p style=\"background-color:blue\">2 </p> "
                    + "<p style=\"background-color:#000000\">3 </p> " + "<p style=\"background-color:#ff9900\">4 </p> "
                    + "<p style=\"background-color:rgb(255,255,255)\">5 </p> " + "<p style=\"background-color:rgb(255,130,255)\">6 </p> "
                    + "<p style=\"background-color:transparent\">7 </p> " + "<p style=\"display: inline\">display: inline</p>"
                    + "<p style=\"display: block\">display: block</p>" + "<p style=\"display: list-item\">display: list-item</p>"
                    + "<p style=\"display: none\">display: none</p>" +

                    "<div bgcolor='blue'>asdfghjkl;,mnbvcxasdfghjk </div>" + "</body></html>";
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