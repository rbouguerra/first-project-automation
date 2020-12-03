package testCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class JeChangeDeCoordonnees2 {

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

	public static void main(String[] args) throws InterruptedException {

		try {
			final Workbook workbook = WorkbookFactory.create(new File("ExportExcel2.xlsx"));
			final Sheet feuille = workbook.getSheet("ExcelSheetDemo");

			int index = 1;
			int numColonne0 = 0, numColonne1 = 1, numColonne2 = 2, numColonne3 = 3, numColonne4 = 4, numColonne5 = 5;
			int numColonne6 = 6, numColonne7 = 7, numColonne8 = 8, numColonne9 = 9, numColonne10 = 10, numColonne11 = 11;
			int numColonne12 = 12, numColonne13 = 13, numColonne14 = 14, numColonne15 = 15, numColonne16 = 16;

			Row row = feuille.getRow(index++);
			System.out.println("The line number is: "+index);

			while (row != null) {

				// Ici exportDateEffet est soit null si la cellule est vide, soit contient ta
				// date sous forme de chaine si la cellule contient une date.
				if (row.getCell(numColonne0).getCellType() != Cell.CELL_TYPE_STRING) {
					Date maDate = row.getCell(numColonne0).getDateCellValue();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					exportDateEffet = df.format(maDate);
				}
				System.out.print(exportDateEffet+ " | ");

				exportNom = row.getCell(numColonne1).getStringCellValue();
				System.out.print(exportNom+ " | ");

				exportPrenom = row.getCell(numColonne2).getStringCellValue();
				System.out.print(exportPrenom+ " | ");

				if (row.getCell(numColonne3).getCellType() != Cell.CELL_TYPE_STRING) {
					Date birthdayDate = row.getCell(numColonne3).getDateCellValue();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					exportDateNaissance = df.format(birthdayDate);
				}
				System.out.print(exportDateNaissance+ " | ");

				exportEscalier = row.getCell(numColonne4).getStringCellValue();
				System.out.print(exportEscalier+ " | ");

				exportResidence = row.getCell(numColonne5).getStringCellValue();
				System.out.print(exportResidence+ " | ");

				exportNumLibelleVoie = row.getCell(numColonne6).getStringCellValue();
				System.out.print(exportNumLibelleVoie+ " | ");
				
				exportCodePostalLocalite = row.getCell(numColonne7).getStringCellValue();
				System.out.print(exportCodePostalLocalite+ " | ");

				Cell cell = row.getCell(numColonne8);
				String stringFormat = cell.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
				String phoneNumber = fmt.format(cell.getNumericCellValue()); // = 06 85 85 65 45
				exportAncienNumTelFixe = phoneNumber.replaceAll("\\s", ""); // = 0685856545
				System.out.print(exportAncienNumTelFixe+ " | ");

				exportEscalierApres = row.getCell(numColonne9).getStringCellValue();
				System.out.print(exportEscalierApres+ " | ");

				exportResidenceApres = row.getCell(numColonne10).getStringCellValue();
				System.out.print(exportResidenceApres+ " | ");

				exportNumLibelleVoieApres = row.getCell(numColonne11).getStringCellValue();
				System.out.print(exportDateEffet+ " | ");

				exportCodePostalLocaliteApres = row.getCell(numColonne12).getStringCellValue();
				System.out.print(exportCodePostalLocaliteApres+ " | ");

				Cell cell1 = row.getCell(numColonne13);
				String stringFormat1 = cell1.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt1 = new CellNumberFormatter(stringFormat1);
				String phoneNumber1 = fmt1.format(cell1.getNumericCellValue()); // = 06 85 85 65 45
				exportNumTelFixeApres = phoneNumber1.replaceAll("\\s", ""); // = 0685856545
				System.out.print(exportNumTelFixeApres+ " | ");
				
				Cell cell2 = row.getCell(numColonne14);
				String stringFormat2 = cell2.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt2 = new CellNumberFormatter(stringFormat2);
				String phoneNumber2 = fmt2.format(cell2.getNumericCellValue()); // = 06 85 85 65 45
				exportTelFixeContact = phoneNumber2.replaceAll("\\s", ""); // = 0685856545
				System.out.print(exportTelFixeContact+ " | ");
				
				Cell cell3 = row.getCell(numColonne15);
				String stringFormat3 = cell3.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt3 = new CellNumberFormatter(stringFormat3);
				String phoneNumber3 = fmt3.format(cell3.getNumericCellValue()); // = 06 85 85 65 45
				exportTelPortableContact = phoneNumber3.replaceAll("\\s", ""); // = 0685856545
				System.out.print(exportTelPortableContact+ " | ");

				exportEmailContact = row.getCell(numColonne16).getStringCellValue();
				System.out.println(exportEmailContact+ " ");

				row = feuille.getRow(index++);
			}
		} catch (Exception e) {
			System.err.println("Erreur lors de l'accès au fichier !");
			e.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver2.exe");
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		driver.get("https://pre-prod.psl.service-public.fr/mademarche/JeChangeDeCoordonnees/demarche?execution=e1s1");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
		//driver.findElement(By.id("inputContactPersonnelTelephone_contactPersoAvant")).sendKeys(exportAncienNumTelFixe);
		driver.findElement(By.id("input_autresCoordonnees2")).sendKeys(exportAncienNumTelFixe);

		driver.findElement(By.id("suivant")).click();
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
		
		/*
		driver.findElement(By.id("recaptcha-anchor-label")).click();
		*/
		//driver.quit();
	}

}
