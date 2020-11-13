package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JeChangeDeCoordonnees {

	public static String exportDateEffet;
	public static String exportNom;
	public static String exportPrenom;
	public static String exportDateNaissance;

	public static String exportEscalier;
	public static String exportResidence;
	public static String exportNumLibelleVoie;
	public static String exportCodePostalLocalite;
	public static String exportAncienNumTelFixe;

	public static String exportEscalierApres;
	public static String exportResidenceApres;
	public static String exportNumLibelleVoieApres;
	public static String exportCodePostalLocaliteApres;
	public static String exportNumTelFixeApres;

	public static String exportTelFixeContact;
	public static String exportTelPortableContact;
	public static String exportEmailContact;

	public static void main(String[] args) throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {

		ReadExcelFile objExcelFile = new ReadExcelFile();

		String filePath = System.getProperty("user.dir", "C:\\Users\\bougu\\eclipse-workspace\\firstProjectAutomation\\ExportExcel2.xlsx");
		objExcelFile.readExcel(filePath, "ExportExcel2.xlsx", "ExcelSheetDemo");
		
//		String filePath = System.getProperty("user.dir", "src/test/resources/temp/Declaration_JCC.xlsx");
//		objExcelFile.readExcel(filePath, "Declaration_JCC.xlsx", "Jcc_Sheet");

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://pre-prod.psl.service-public.fr/mademarche/JeChangeDeCoordonnees/demarche?execution=e1s1");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("dateEffet")).sendKeys(exportDateEffet);
		driver.findElement(By.id("input_autresCoordonnees1")).click();
		
		driver.findElement(By.id("suivant")).click();

		driver.findElement(By.id("input_civilite1")).click();
		driver.findElement(By.id("nomFamille")).sendKeys(exportNom);
		driver.findElement(By.id("prenoms")).sendKeys(exportPrenom);
		driver.findElement(By.id("dateNaissance")).sendKeys(exportDateNaissance);

		driver.findElement(By.id("inputAdresseFrEtage_adresseFrAvant")).sendKeys(exportEscalier);
		driver.findElement(By.id("inputAdresseFrImmeuble_adresseFrAvant")).sendKeys(exportResidence);
		driver.findElement(By.id("inputAdresseFrVoie_adresseFrAvant")).sendKeys(exportNumLibelleVoie);
		driver.findElement(By.id("inputAdresseFrLocaliteCP_adresseFrAvant")).sendKeys(exportCodePostalLocalite);
		driver.findElement(By.id("inputContactPersonnelTelephone_contactPersoAvant")).sendKeys(exportAncienNumTelFixe);

		driver.findElement(By.id("suivant")).click();

		driver.findElement(By.id("inputAdresseFrEtage_adresseFrApres")).sendKeys(exportEscalierApres);
		driver.findElement(By.id("inputAdresseFrImmeuble_adresseFrApres")).sendKeys(exportResidenceApres);
		driver.findElement(By.id("inputAdresseFrVoie_adresseFrApres")).sendKeys(exportNumLibelleVoieApres);
		driver.findElement(By.id("inputAdresseFrLocaliteCP_adresseFrApres")).sendKeys(exportCodePostalLocaliteApres);
		driver.findElement(By.id("inputContactPersonnelTelephone_contactPersoApres")).sendKeys(exportNumTelFixeApres);

		driver.findElement(By.id("suivant")).click();
		driver.findElement(By.id("suivant")).click();

		driver.findElement(By.xpath(
				"//body/div[@id='outer-wrap']/div[@id='inner-wrap']/main[@id='main']/div[1]/div[3]/form[1]/div[2]/div[1]/fieldset[3]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"))
				.click();

		driver.findElement(By.id("suivant")).click();

		driver.findElement(By.id("inputContactPersonnelTelephone_contactPersoRecap")).sendKeys(exportTelFixeContact);
		driver.findElement(By.id("inputContactPersonnelMobile_contactPersoRecap")).sendKeys(exportTelPortableContact);
		driver.findElement(By.id("inputContactPersonnelCourriel_contactPersoRecap")).sendKeys(exportEmailContact);

		driver.findElement(By.id("suivant")).click();

		driver.findElement(By.id("chMail2")).sendKeys(exportEmailContact);
		driver.findElement(By.id("recaptcha-anchor-label")).click();

		// driver.quit();

	}

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		Row row = null;

		for (int i = 0; i < rowCount + 1; i++) {

			row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue() + "|");
				
				if (row.getCell(0).getCellType() != Cell.CELL_TYPE_STRING) {
					Date maDate = row.getCell(0).getDateCellValue();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					exportDateEffet = df.format(maDate);
				}
				System.out.print(exportDateEffet+ " | ");

				exportNom = row.getCell(1).getStringCellValue();

				exportPrenom = row.getCell(2).getStringCellValue();
				
				if (row.getCell(3).getCellType() != Cell.CELL_TYPE_STRING) {
					Date birthdayDate = row.getCell(3).getDateCellValue();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					exportDateNaissance = df.format(birthdayDate);
				}

				exportEscalier = row.getCell(4).getStringCellValue();

				exportResidence = row.getCell(5).getStringCellValue();

				exportNumLibelleVoie = row.getCell(6).getStringCellValue();
				
				exportCodePostalLocalite = row.getCell(7).getStringCellValue();

				Cell cell = row.getCell(8);
				String stringFormat = cell.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
				String phoneNumber = fmt.format(cell.getNumericCellValue()); // = 06 85 85 65 45
				exportAncienNumTelFixe = phoneNumber.replaceAll("\\s", ""); // = 0685856545

				exportEscalierApres = row.getCell(9).getStringCellValue();

				exportResidenceApres = row.getCell(10).getStringCellValue();

				exportNumLibelleVoieApres = row.getCell(11).getStringCellValue();
	
				exportCodePostalLocaliteApres = row.getCell(12).getStringCellValue();

				Cell cell1 = row.getCell(13);
				String stringFormat1 = cell1.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt1 = new CellNumberFormatter(stringFormat1);
				String phoneNumber1 = fmt1.format(cell1.getNumericCellValue()); // = 06 85 85 65 45
				exportNumTelFixeApres = phoneNumber1.replaceAll("\\s", ""); // = 0685856545
				
				Cell cell2 = row.getCell(14);
				String stringFormat2 = cell2.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt2 = new CellNumberFormatter(stringFormat2);
				String phoneNumber2 = fmt2.format(cell2.getNumericCellValue()); // = 06 85 85 65 45
				exportTelFixeContact = phoneNumber2.replaceAll("\\s", ""); // = 0685856545
				
				Cell cell3 = row.getCell(15);
				String stringFormat3 = cell3.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt3 = new CellNumberFormatter(stringFormat3);
				String phoneNumber3 = fmt3.format(cell3.getNumericCellValue()); // = 06 85 85 65 45
				exportTelPortableContact = phoneNumber3.replaceAll("\\s", ""); // = 0685856545

				exportEmailContact = row.getCell(16).getStringCellValue();
			}
		}

		System.out.println();
	}

}
