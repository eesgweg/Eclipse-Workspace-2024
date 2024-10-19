package excelpracs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			FileInputStream fis = new FileInputStream("G:\\A.xls");
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(rowcount);
			System.out.println(colCount);
			for(Row  row: sheet) {
				for(Cell cell : row) {
					switch(cell.getCellType()) {
						case NUMERIC:
							System.out.println(cell.getNumericCellValue());
							break;
						case STRING:
							System.out.println(cell.getStringCellValue());
							break;
						case BOOLEAN:
							System.out.println(cell.getBooleanCellValue());
							break;
						case FORMULA:
							System.out.println(cell.getCellFormula());
							break;
						default:
							System.out.println(cell.getStringCellValue());
					}
				}
				row.createCell(colCount+1).setCellValue(true);
			}
			
			FileOutputStream fos = new FileOutputStream("G:\\A.xls");
			wb.write(fos);
			wb.close();
			
			
	}

}
