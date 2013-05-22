package barCode;

import java.awt.Color;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;

public class Marker {
    
    /**
     * This method creat Mark whit proporshin 
     * @param content - where we write 
     * @param x - lower left x
     * @param y - lower left y
     * @param size - size of mark
     */
    public static void mark (PdfContentByte content, int x, int y, float size) {
        //Proportion 1:1:3:1:1
        float sizeStep = size/7;
        Rectangle rec = new Rectangle(x, y, x+size, y+size);
       
        //settings of big rectangle
        rec.setBorder(Rectangle.BOX);
        rec.setBorderWidth(sizeStep);
        rec.setBorderColor(Color.black);
        rec.setBackgroundColor(Color.black);
        content.rectangle(rec);
        
        // setting of small rectangle white border
        rec = new Rectangle(x+sizeStep, y+sizeStep, x+size-sizeStep, y+size-sizeStep);
        rec.setBorder(Rectangle.BOX);
        rec.setBorderWidth(sizeStep);
        rec.setBorderColor(Color.white);
        content.rectangle(rec);
        
        content.fillStroke();
    }

}
