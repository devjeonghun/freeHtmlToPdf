import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

public class FreeHtmlToPdf {

	
	public static void main(String[] args) throws Exception {
	    File file = new File("asd.html");
	    InputStream is = null;
	    try
	    {
	      is = new FileInputStream(file);
	    }
	    catch (FileNotFoundException e)
	    {
	      e.printStackTrace();
	    }
	    StringWriter sw = new StringWriter();
	    StringBuffer sb = sw.getBuffer();
	    Tidy tidy = new Tidy();
	    tidy.setQuiet(false);
	    tidy.setShowWarnings(true);
	    tidy.setInputEncoding("UTF-8");
	    tidy.setOutputEncoding("UTF-8");
	    
	    tidy.setForceOutput(true);
	    tidy.parse(is, sw);
	    
	    String outputFile = "asd.pdf";
	    OutputStream os = new FileOutputStream(outputFile);
	    
	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(sb.toString());
	    renderer.getFontResolver().addFont("notokr-regular.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	    renderer.layout();
	    renderer.createPDF(os, false);
	    
	    renderer.setDocumentFromString(sb.toString());
	    renderer.getFontResolver().addFont("notokr-regular.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	    renderer.layout();
	    renderer.writeNextDocument();
	    
	    renderer.finishPDF();
	    os.close();
	}
}
