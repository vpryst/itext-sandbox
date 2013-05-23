package barCode;

import static barCode.Marker.mark;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class MarkerPdfDemo {

    /**
     * @param args
     * @throws DocumentException
     * @throws IOException
     */

    public static void main(String[] args) throws DocumentException, IOException {

        File filename = File.createTempFile("MrakerDemo", ".pdf");
        // step 1
        Document document = new Document(PageSize.LETTER);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();

        PdfContentByte canvas = writer.getDirectContent();

        mark(canvas, 200, 200, 6);
        mark(canvas, 220, 220, 14);
        mark(canvas, 280, 280, 21);
        mark(canvas, 350, 350, 35);

        // step 5
        document.close();

        Desktop.getDesktop().open(filename);
    }

}
