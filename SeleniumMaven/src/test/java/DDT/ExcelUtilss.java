package DDT;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtilss {
	@Test
	public static void readExcelData(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = new HSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);

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

					data[rowIndex][colIndex] = NumberToTextConverter.toText(c.getNumericCellValue());
				}

			}
			rowIndex++;
		}
		workbook.close();
		file.close();
		System.out.println(data);
//        return data;
	}
}
