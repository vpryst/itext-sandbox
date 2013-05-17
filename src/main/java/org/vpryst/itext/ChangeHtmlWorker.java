package org.vpryst.itext;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocListener;
import com.lowagie.text.Element;
import com.lowagie.text.ElementTags;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.html.Markup;
import com.lowagie.text.html.simpleparser.ChainedProperties;
import com.lowagie.text.html.simpleparser.FactoryProperties;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.ImageProvider;
import com.lowagie.text.html.simpleparser.Img;
import com.lowagie.text.html.simpleparser.IncCell;
import com.lowagie.text.html.simpleparser.IncTable;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.draw.LineSeparator;

public class ChangeHtmlWorker extends ExHTMLWorker {

    public ChangeHtmlWorker(DocListener document) {
        super(document);
    }

    @Override
    public void startElement(String tag, HashMap h) {
       super.startElement(tag, h);
    }
}
