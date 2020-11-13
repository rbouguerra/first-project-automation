//package testCases;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Iterator;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//public class ReadExcelFile3 {
//		 
//		    public static void main(String[] args) throws IOException {
//		 
//		        // Read XSL file
//		        FileInputStream inputStream = new FileInputStream(new File("C:/demo/employee.xls"));
//		 
//		        // Get the workbook instance for XLS file
//		        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//		 
//		        // Get first sheet from the workbook
//		        HSSFSheet sheet = workbook.getSheetAt(0);
//		 
//		        // Get iterator to all the rows in current sheet
//		        Iterator<Row> rowIterator = sheet.iterator();
//		 
//		        while (rowIterator.hasNext()) {
//		            Row row = rowIterator.next();
//		            // Get iterator to all cells of current row
//		            Iterator<Cell> cellIterator = row.cellIterator();
//		 
//		            while (cellIterator.hasNext()) {
//		                Cell cell = cellIterator.next();
//		 
//		                // Change to getCellType() if using POI 4.x
//		                CellType cellType = cell.getCellTypeEnum();
//		 
//		                switch (cellType) {
//		                case _NONE:
//		                    System.out.print("");
//		                    System.out.print("\t");
//		                    break;
//		                case BOOLEAN:
//		                    System.out.print(cell.getBooleanCellValue());
//		                    System.out.print("\t");
//		                    break;
//		                case BLANK:
//		                    System.out.print("");
//		                    System.out.print("\t");
//		                    break;
//		                case FORMULA:
//		                    // Formula
//		                    System.out.print(cell.getCellFormula());
//		                    System.out.print("\t");
//		                     
//		                    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//		                    // Print out value evaluated by formula
//		                    System.out.print(evaluator.evaluate(cell).getNumberValue());
//		                    break;
//		                case NUMERIC:
//		                    System.out.print(cell.getNumericCellValue());
//		                    System.out.print("\t");
//		                    break;
//		                case STRING:
//		                    System.out.print(cell.getStringCellValue());
//		                    System.out.print("\t");
//		                    break;
//		                case ERROR:
//		                    System.out.print("!");
//		                    System.out.print("\t");
//		                    break;
//		                }
//		 
//		            }
//		            System.out.println("");
//		        }
//		    }
//		 
//		}
//		
////		public String getExceldata(String sheetname,int rownum,int cellnum, boolean isString) {
////		    String retVal=null;
////		    try {
////		        FileInputStream fis=new FileInputStream("C:\\Users\\bougu\\eclipse-workspace\\firstProjectAutomation\\Declaration_JCC.xlsx");
////		        Workbook wb=WorkbookFactory.create(fis);
////		        Sheet s=wb.getSheet(sheetname);
////		        Row r=s.getRow(rownum);
////		        Cell c=r.getCell(cellnum);
////		        if(c.getCellType() == Cell.CELL_TYPE_STRING)
////		        retVal=c.getStringCellValue();
////		        else {
////		            retVal = String.valueOf(c.getNumericCellValue());
////		        }
////
////		    }
////		}
//		
////		InputStream inp =getClass().getResourceAsStream("filename.xls"));
////		Workbook wb = WorkbookFactory.create(inp);
////		DataFormatter objDefaultFormat = new DataFormatter();
////		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
////
////		Sheet sheet= wb.getSheetAt(0);
////		Iterator<Row> objIterator = sheet.rowIterator();
////
////		while(objIterator.hasNext()){
////
////		    Row row = objIterator.next();
////		    Cell cellValue = row.getCell(0);
////		    objFormulaEvaluator.evaluate(cellValue); //This will evaluate the cell, And any type of cell will return string value
////		    String cellValueStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);
//
//		
//}
//}
