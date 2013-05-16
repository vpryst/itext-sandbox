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
        /*float sizeText = parseLength(String.valueOf(size), Markup.DEFAULT_FONT_SIZE);
        if (sizeText==0.0) {
            sizeText = Font.DEFAULTSIZE;
        }
        System.out.println(parseLength(String.valueOf(size), Markup.DEFAULT_FONT_SIZE));*/

        return new Font(Font.TIMES_ROMAN, size, style, color);
 
   }
    @Override
    public Font getFont(Properties attributes) {
        String fontname = null;
        String encoding = defaultEncoding;
        boolean embedded = defaultEmbedding;
        float size = Font.UNDEFINED;
        int style = Font.NORMAL;
        Color color = null;
        String value = attributes.getProperty(Markup.HTML_ATTR_STYLE);
        if (value != null && value.length() > 0) {
            Properties styleAttributes = Markup.parseAttributes(value);
            if (styleAttributes.isEmpty()) {
                attributes.put(Markup.HTML_ATTR_STYLE, value);
            }
            else {
                fontname = styleAttributes.getProperty(Markup.CSS_KEY_FONTFAMILY);
                if (fontname != null) {
                    String tmp;
                    while (fontname.indexOf(',') != -1) {
                        tmp = fontname.substring(0, fontname.indexOf(','));
                        if (isRegistered(tmp)) {
                            fontname = tmp;
                        }
                        else {
                            fontname = fontname.substring(fontname.indexOf(',') + 1);
                        }
                    }
                }
                if ((value = styleAttributes.getProperty(Markup.CSS_KEY_FONTSIZE)) != null) {
                    size = parseLength(value, Markup.DEFAULT_FONT_SIZE);
                }
                if ((value = styleAttributes.getProperty(Markup.CSS_KEY_FONTWEIGHT)) != null) {
                    style |= Font.getStyleValue(value);
                }
                if ((value = styleAttributes.getProperty(Markup.CSS_KEY_FONTSTYLE)) != null) {
                    style |= Font.getStyleValue(value);
                }
                if ((value = styleAttributes.getProperty(Markup.CSS_KEY_COLOR)) != null) {
                    color = Markup.decodeColor(value);
                }
                attributes.putAll(styleAttributes);
                for (Enumeration e = styleAttributes.keys(); e.hasMoreElements();) {
                    Object o = e.nextElement();
                    attributes.put(o, styleAttributes.get(o));
                }
            }
        }
        if ((value = attributes.getProperty(ElementTags.ENCODING)) != null) {
            encoding = value;
        }
        if ("true".equals(attributes.getProperty(ElementTags.EMBEDDED))) {
            embedded = true;
        }
        if ((value = attributes.getProperty(ElementTags.FONT)) != null) {
            fontname = value;
        }
        if ((value = attributes.getProperty(ElementTags.SIZE)) != null) {
            size = Markup.parseLength(value);
        }
        if ((value = attributes.getProperty(Markup.HTML_ATTR_STYLE)) != null) {
            style |= Font.getStyleValue(value);
        }
        if ((value = attributes.getProperty(ElementTags.STYLE)) != null) {
            style |= Font.getStyleValue(value);
        }
        String r = attributes.getProperty(ElementTags.RED);
        String g = attributes.getProperty(ElementTags.GREEN);
        String b = attributes.getProperty(ElementTags.BLUE);
        if (r != null || g != null || b != null) {
            int red = 0;
            int green = 0;
            int blue = 0;
            if (r != null) red = Integer.parseInt(r);
            if (g != null) green = Integer.parseInt(g);
            if (b != null) blue = Integer.parseInt(b);
            color = new Color(red, green, blue);
        }
        else if ((value = attributes.getProperty(ElementTags.COLOR)) != null) {
            color = Markup.decodeColor(value);
        }
        if (fontname == null) {
            return getFont(null, encoding, embedded, size, style, color);
        }
        return getFont(fontname, encoding, embedded, size, style, color);
    }
    
    public static float parseLength(String string, float actualFontSize) {
        if (string == null)
            return 0f;
        int pos = 0;
        int length = string.length();
        boolean ok = true;
        while (ok && pos < length) {
            switch (string.charAt(pos)) {
            case '+':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '.':
                pos++;
                break;
            default:
                ok = false;
            }
        }
        if (pos == 0)
            return 0f;
        if (pos == length)
            return Float.parseFloat(string + "f");
        float f = Float.parseFloat(string.substring(0, pos) + "f");
        string = string.substring(pos);
        // inches
        if (string.startsWith("in")) {
            return f * 72f;
        }
        // centimeters
        if (string.startsWith("cm")) {
            return (f / 2.54f) * 72f;
        }
        // millimeters
        if (string.startsWith("mm")) {
            return (f / 25.4f) * 72f;
        }
        // picas
        if (string.startsWith("pc")) {
            return f * 12f;
        }
        // 1em is equal to the current font size
        if (string.startsWith("em")) {
            return f * actualFontSize;
        }
        // one ex is the x-height of a font (x-height is usually about half the
        // font-size)
        if (string.startsWith("ex")) {
            return f * actualFontSize / 2;
        }
        if (string.startsWith("large")) {
            return f * actualFontSize * 2;
        }
        if (string.startsWith("small")) {
            return f * actualFontSize / 2;
        }
        // default: we assume the length was measured in points
        return f;
    }
}
