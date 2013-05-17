package differanceVerison.ver5_4_1;

/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
public class HtmlToPDF2 {

      // itextpdf-5.4.1.jar  http://sourceforge.net/projects/itext/files/iText/
      // xmlworker-5.4.1.jar http://sourceforge.net/projects/xmlworker/files/
      public static void main(String ... args ) {
            try {
              Document document = new Document(PageSize.LETTER);
              PdfWriter pdfWriter = PdfWriter.getInstance
                   (document, new FileOutputStream("testpdf.pdf"));
              document.open();
              document.addAuthor("Real Gagnon");
              document.addCreator("Real's HowTo");
              document.addSubject("Thanks for your support");
              document.addCreationDate();
              document.addTitle("Please read this");

              XMLWorkerHelper worker = XMLWorkerHelper.getInstance();

              String str = ""; /*"<html><head></head><body>"+
                "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
                "<h1>Show your support</h1>" +
                "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
                "in personal hardware and software costs to set up test environments, and above all," +
                "the huge amounts of time it takes for one person to design and write the actual content.</p>" +
                "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?</p>" +
                "<p>Donate using PayPal� to real@rgagnon.com.</p>" +
                "<p>Contributions via PayPal are accepted in any amount</p>" +
                "<P><br/><table border='1'><tr><td>Java HowTo</td></tr><tr>" +
                "<td style='background-color:red;'>Javascript HowTo</td></tr>" +
                "<tr><td>Powerbuilder HowTo</td></tr></table></p>" +
                "</body></html>";*/
              
              
              
              str = "<span style=\"font-size: medium;font-family: Arial;\">I was at the railway station when I heard <font size=\"4\"><b>6 tolls</b></font> of the clock. It was <b><font size=\"4\">6 o'clock</font></b>. Out of curiosity I measured that it took <font><b><font face=\"times new roman\">30 seconds for 6 tolls</font></b></font>.&nbsp; I concluded that it will take <b><font>1 minute for 12 tolls at 12 o'clock</font></b>.&nbsp; Am I correct?</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">Can you recognize the following solid?<br></br></span>"
                  + "<div align=\"center\"><b><span style=\"font-size: medium;font-family: Arial;\">&nbsp;There are five chains with 3 links in each chain. It takes $1 to break one link and $2 to join it back. What would it cost to make a single chain out of 5 chains?</span></b></div>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">Two trains started from stations A and B, 300 km apart with speeds 40 km/hr and 60 km/hr respectively towards each other at the same time. At the same time a bird started flying from station A to station B with speed 100 km/hr.&nbsp; On the flight when it reached the second train it turned back. When it reached the first train it turned back. This continued till the trains met each other on the way. Is the distance traveled by the bird deterministic?</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;How many <font size=\"5\"><b>rectangles </b></font>can be formed in the figure below?</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;What is the next number in the following sequence?<br></br><br></br>1&nbsp;&nbsp; &nbsp;11&nbsp;&nbsp; &nbsp;21&nbsp;&nbsp; &nbsp;1211&nbsp;&nbsp;&nbsp; ____<br></br></span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">John has few coins.<br></br></span><br></br><ul><li><span style=\"font-size: medium;font-family: Arial;\">He stacked them in 2 coins per stack. 1 coin left.&nbsp; <br></br></span></li><li><span style=\"font-size: medium;font-family: Arial;\">He re-arranged them in stacks of 3, 1 coin left. <br></br></span></li><li><span style=\"font-size: medium;font-family: Arial;\">He re-arranged them in stacks of 4, 1 coin left.&nbsp; <br></br></span></li><li><span style=\"font-size: medium;font-family: Arial;\">He arranged them in stacks of 5, still 1 coin left. <br></br></span></li><li><span style=\"font-size: medium;font-family: Arial;\">He arranged them in stacks of 6, again 1 coin left. <br></br></span></li><li><span style=\"font-size: medium;font-family: Arial;\">Finally with stacks of 7 all stacks were complete with no coin left.&nbsp;&nbsp;</span><span style=\"font-size: medium;font-family: Arial;\"></span></li></ul><span style=\"font-size: medium;font-family: Arial;\"><br></br>How many coins John has?&nbsp; <br></br></span><br></br>";
              
              
              str += "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;Pyramid</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;Cuboid</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;Circular Prism<br></br></span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;Cylinder</span>";              

              
              
              str += "<span><font><span><span><span><sub><font><font size=\"4\"><font face=\"tahoma\">$6</font></font></font></sub><br></br></span></span></span></font></span>"
                  + "<font><u><font face=\"courier new\"><span style=\"font-size: medium;\">$9</span></font></u></font>"
                  + "<font face=\"times new roman\"><span style=\"font-size: medium;\">&nbsp;$15</span></font>"
                  + "<b><font><span style=\"font-size: medium;font-family: Arial;\">$12</span></font></b>";

              
              str += "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;120</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;140</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;150</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;130</span>";

              
              str += "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;None of the above<br></br>.Do you really think it is a valid sequence?<br></br>I don't think so.</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;72111</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;2111</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;1221</span>";
              
              str += "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;121</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;None of the above<br></br></span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;49</span>"
                  + "<span style=\"font-size: medium;font-family: Arial;\">&nbsp;63</span>";
               worker.parseXHtml(pdfWriter, document, new StringReader(str));
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              //worker.parseXHtml(pdfWriter, document, new StringReader(str));
              document.close();
              System.out.println("Done.");
              }
            catch (Exception e) {
              e.printStackTrace();
            }
          }

}