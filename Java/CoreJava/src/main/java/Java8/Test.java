package Corejava;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.ElementHandlerPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;



public class Test
{
	
	static void pdftoDoc() throws IOException {
		XWPFDocument doc = new XWPFDocument();
		String pdf = "D:\\Ashish\\Study\\Angular JS Learning\\Test\\Credit_Proposal.pdf";
		PdfReader reader = new PdfReader(pdf);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			TextExtractionStrategy strategy =
					parser.processContent(i, new SimpleTextExtractionStrategy());
			String text = strategy.getResultantText();
			XWPFParagraph p = doc.createParagraph();
			XWPFRun run = p.createRun();
			run.setText(text);
			run.addBreak(BreakType.PAGE);
		}
		FileOutputStream out = new FileOutputStream("D:\\Ashish\\Study\\Angular JS Learning\\Test\\Credit_Proposal.doc");
		doc.write(out);
	}


	public static void convertHTMLtoPDF() throws FileNotFoundException, IOException  
	{
		
		String FONT = "src/Corejava/Frutiger_LT_45_Light.ttf";
		ConverterProperties properties = new ConverterProperties();
		FontProvider fontProvider = new DefaultFontProvider();
	    FontProgram fontProgram = FontProgramFactory.createFont(FONT);
	    fontProvider.addFont(fontProgram);
	    properties.setFontProvider(fontProvider);
	    HtmlConverter.convertToPdf(new FileInputStream("D:\\Ashish\\Study\\Angular JS Learning\\Test\\RESCHEDULE_CHECK.html"), 
				new FileOutputStream("D:\\Ashish\\Study\\Angular JS Learning\\Credit_Proposal.pdf"),properties);
	   // HtmlConverter.convertToPdf(new File(src), new File(dest), properties);
		

		System.out.println( "PDF Created!" );
	}
	/*static String pdftoText(String fileName) {
		PDFParser parser;
		String parsedText = null;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(fileName);
		if (!file.isFile()) {
			System.err.println("File " + fileName + " does not exist.");
			return null;
		}
		try {
			parser = new PDFParser(new FileInputStream(file));
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.err
			.println("An exception occured in parsing the PDF Document."
					+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return parsedText;
	}*/

	public static void main(String args[]){

		try {
			//pdftoDoc();
			convertHTMLtoPDF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String content = pdftoText("D:\\Ashish\\Study\\Angular JS Learning\\Test\\Credit_Proposal.pdf");

		//File file = new File("D:\\Ashish\\Study\\Angular JS Learning\\Test\\Credit_Proposal.doc");

		// if file doesnt exists, then create it
		//if (!file.exists()) {
		//file.createNewFile();
		//}
		//java.io.FileWriter fw = new FileWriter(file.getAbsoluteFile());
		//BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(content);
		//bw.close();

	} 
}
