package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelFile {

	public static String exportUserName;
	public static String exportPassword;

	public static void main(String[] args) throws IOException {

		// Create an object of ReadExcelFile class
		ReadExcelFile objExcelFile = new ReadExcelFile();

		// Prepare the path of excel file
		String filePath = System.getProperty("user.dir", "src/test/resources/temp/ExportExcel2.xlsx");

		// Call read file method of the class to read data
		objExcelFile.readExcel(filePath, "ExportExcel2.xlsx", "ExcelSheetDemo");

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);

		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).sendKeys(exportUserName);

		driver.findElement(By.id("txtPassword")).sendKeys(exportPassword);

		driver.findElement(By.id("btnLogin")).click();

		driver.quit();

	}

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name
		Sheet sheet = workbook.getSheet(sheetName);

		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue() + "|");

				exportUserName = row.getCell(0).getStringCellValue();

				exportPassword = row.getCell(1).getStringCellValue();
			}

			System.out.println();
		}

	}

}