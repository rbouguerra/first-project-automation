package testCases;
//package testCases;

//import java.io.BufferedInputStream;
//import java.io.InputStream;
//import java.net.URL;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ReadPdfFile {
//
//	private static final String EmptyFileException = null;
//
//	public static void main(String[] args) {
//		
//		
//		public String readPDF() EmptyFileException {
//			
//			WebDriver driver = new ChromeDriver();
//			
//			// page with example pdf document
//			driver.get("file:///C:/Users/admin/Downloads/dotnet_TheRaceforEmpires.pdf");
//			
//			URL url = new URL(driver.getCurrentUrl());
//			
//			InputStream is = url.openStream();
//			
//			BufferedInputStream fileToParse = new BufferedInputStream(is);
//			
//			PDDocument document = null;
//			
//			try {
//			document = PDDocument.load(fileToParse);
//			
//			String output = new PDFTextStripper().getText(document);
//			} finally {
//			if (document != null) {
//			document.close();
//			}
//			fileToParse.close();
//			is.close();
//			}
//			 
//			return output;
//			}
//
//	}
//
//}
