package barCode;

import java.awt.Color;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;

public class Marker {

    /**
     * This method creat Mark whit proporshin
     * 
     * @param content - where we write
     * @param x - lower left x
     * @param y - lower left y
     * @param size - size of mark
     */
    public static void mark(PdfContentByte content, int x, int y, float size) {
        // Proportion 1:1:3:1:1
        int sizeStep = (int) (size / 7);
        int center = (int) (size/2);
        if (sizeStep < 1) {
            try {
                throw new IllegalArgumentException("Marker must be aliquot 7");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Rectangle rec = new Rectangle(x-center, y-center, x + center, y + center);

            // settings of big rectangle
            rec.setBorder(Rectangle.BOX);
            rec.setBorderWidth(sizeStep);
            rec.setBorderColor(Color.black);
            rec.setBackgroundColor(Color.black);
            content.rectangle(rec);

            // setting of small rectangle white border
            rec = new Rectangle(x + sizeStep-center, y + sizeStep-center, x - sizeStep + center, y - sizeStep + center);
            rec.setBorder(Rectangle.BOX);
            rec.setBorderWidth(sizeStep);
            rec.setBorderColor(Color.white);
            content.rectangle(rec);

            content.fillStroke();
        }
    }

}
