package org.vpryst.itext;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Properties;

import com.lowagie.text.ElementTags;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactoryImp;
import com.lowagie.text.html.Markup;

public class MyFontFactory extends FontFactoryImp {

    @Override
    public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, Color color) {
        /*
         * float sizeText = parseLength(String.valueOf(size), Markup.DEFAULT_FONT_SIZE); if (sizeText==0.0) { sizeText = Font.DEFAULTSIZE; }
         * System.out.println(parseLength(String.valueOf(size), Markup.DEFAULT_FONT_SIZE));
         */

        return new Font(Font.TIMES_ROMAN, size, style, color);
    }
}
