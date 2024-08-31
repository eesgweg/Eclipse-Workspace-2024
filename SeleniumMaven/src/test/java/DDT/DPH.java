package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPH {
	@Test(dataProvider = "studentDataProvider")
    public void testStudentData(String name,String S1,String S2,String S3,String Percentage) {
       
        System.err.println( name+" : " +Percentage);
        System.err.println(S1+" || "+S3+" || "+S3);
    }
	
	@DataProvider(name = "studentDataProvider")
	public Object[][] Dataprovider() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\swats\\OneDrive\\Desktop\\Study\\StudentMarks.xls");
		Workbook workbook = new HSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(1);

		Iterator<Row> rowIterator = sheet.iterator();
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount];

		int rowIndex = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() == 0)
				continue; // skip header row

			for (int colIndex = 0; colIndex < colCount; colIndex++) {
				Cell c = row.getCell(colIndex);
				if (c.getCellType() == CellType.STRING) {

					data[rowIndex][colIndex] = c.getStringCellValue();
				} else if (c.getCellType() == CellType.NUMERIC) {
					
					data[rowIndex][colIndex] = (NumberToTextConverter.toText(c.getNumericCellValue())).substring(0,2);
				}

			}
			rowIndex++;
		}

		workbook.close();
		file.close();

        return data;

		
	}

}
