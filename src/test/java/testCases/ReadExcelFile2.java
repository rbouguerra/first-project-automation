package testCases;

import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile2 {

	public static void main(String[] args) {
		try {
			final Workbook workbook = WorkbookFactory.create(new File("ExportExcel2.xlsx"));
			final Sheet feuille = workbook.getSheet("ExcelSheetDemo");
			int index = 0;
			int numColonne0 = 0;
			int numColonne1 = 1;
			int numColonne2 = 2;
			int numColonne8 = 8;
			int numColonne13 = 13;
			int numColonne14 = 14;
			int numColonne15 = 15, numColonne16 = 16;

			Row row = feuille.getRow(index++);
			while (row != null) {

//				DataFormatter dataFormatter1 = new DataFormatter();
//				String cellStringValue = dataFormatter1.formatCellValue(row.getCell(numColonne0));
//				System.out.println("Is shows data as show in Excel file mm/jj/aa" + " | " + cellStringValue); 
//				// Here it automcatically format data based on that cell format.
//				// No need for extra efforts.

				if (row.getCell(numColonne0).getCellType() != Cell.CELL_TYPE_STRING) {
					Date maDate = row.getCell(numColonne0).getDateCellValue();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String exportDateEffet = df.format(maDate);
					System.out.println(exportDateEffet + " | ");
				}

				/* First Method */
				DataFormatter dataFormatter = new DataFormatter();
				String NumTelFixe = dataFormatter.formatCellValue(row.getCell(numColonne8));
				System.out.println("The result of the first method is: " + NumTelFixe); // = 685856545,0 if the type of
																						// the cell is Double

				/* Second Method */
				Cell cell = row.getCell(numColonne8);
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String NumTelFixe1 = NumberToTextConverter.toText(cell.getNumericCellValue());
					System.out.println("The result of the second method is: " + NumTelFixe1); // = 685856545
				}

				/* Third Method */
				String stringFormat = cell.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
				String phoneNumber = fmt.format(cell.getNumericCellValue()); // = 06 85 85 65 45
				System.out.println("With space: " + phoneNumber);
				String exportAncienNumTelFixe = phoneNumber.replaceAll("\\s", "");
				System.out.println("Without space cell : " + exportAncienNumTelFixe);

//								
//				//new java.text.DecimalFormat("0").format( cell.getNumericCellValue() );

				Cell cell1 = row.getCell(numColonne13);
				String stringFormat1 = cell1.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt1 = new CellNumberFormatter(stringFormat1);
				String phoneNumber1 = fmt1.format(cell1.getNumericCellValue()); // = 06 85 85 65 45
				String exportNumTelFixeApres = phoneNumber1.replaceAll("\\s", ""); // = 0685856545
				System.out.println("Without space cell1 : " + exportNumTelFixeApres);

				Cell cell2 = row.getCell(numColonne14);
				String stringFormat2 = cell2.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt2 = new CellNumberFormatter(stringFormat2);
				String phoneNumber2 = fmt2.format(cell2.getNumericCellValue()); // = 06 85 85 65 45
				String exportTelFixeContact = phoneNumber2.replaceAll("\\s", ""); // = 0685856545
				System.out.println("Without space cell2 : " + exportTelFixeContact);

				Cell cell3 = row.getCell(numColonne15);
				String stringFormat3 = cell3.getCellStyle().getDataFormatString();
				CellNumberFormatter fmt3 = new CellNumberFormatter(stringFormat3);
				String phoneNumber3 = fmt3.format(cell3.getNumericCellValue()); // = 06 85 85 65 45
				String exportTelPortableContact = phoneNumber3.replaceAll("\\s", ""); // = 0685856545
				System.out.println("Without space cell3 : " + exportTelPortableContact);

				String exportEmailContact = row.getCell(numColonne16).getStringCellValue();
				System.out.println("Email contact: " + exportEmailContact);

				row = feuille.getRow(index++);
			}
		} catch (Exception e) {
			System.err.println("Erreur lors de l'accès au fichier !");
			e.printStackTrace();
		}
	}

}

/*
 * public void readExcel(String filePath, String fileName, String sheetName)
 * throws IOException {
 * 
 * // Create an object of File class to open xlsx file File file = new
 * File(filePath + "\\" + fileName);
 * 
 * // Create an object of FileInputStream class to read excel file
 * FileInputStream inputStream = new FileInputStream(file); Workbook workbook =
 * null;
 * 
 * // Find the file extension by splitting file name in substring and getting
 * only // extension name String fileExtensionName =
 * fileName.substring(fileName.indexOf("."));
 * 
 * // Check condition if the file is xlsx file if
 * (fileExtensionName.equals(".xlsx")) {
 * 
 * // If it is xlsx file then create object of XSSFWorkbook class workbook = new
 * XSSFWorkbook(inputStream);
 * 
 * }
 * 
 * // Check condition if the file is xls file else if
 * (fileExtensionName.equals(".xls")) {
 * 
 * // If it is xls file then create object of HSSFWorkbook class workbook = new
 * HSSFWorkbook(inputStream);
 * 
 * }
 * 
 * // Read sheet inside the workbook by its name Sheet sheet =
 * workbook.getSheet(sheetName);
 * 
 * // Find number of rows in excel file int rowCount = sheet.getLastRowNum() -
 * sheet.getFirstRowNum();
 * 
 * // Create a loop over all the rows of excel file to read it
 * 
 * for (int i = 0; i < rowCount + 1; i++) {
 * 
 * Row row = sheet.getRow(i);
 * 
 * // Create a loop to print cell values in a row for (int j = 0; j <
 * row.getLastCellNum(); j++) {
 * 
 * // Print Excel data in console
 * System.out.print(row.getCell(j).getStringCellValue() + "|"); } } }
 */
