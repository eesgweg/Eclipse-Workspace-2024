package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class Excel_Collections {

	public static void main(String[] args) throws IOException {
			String Path = "D:\\A.xls";
			FileInputStream fis = new FileInputStream(Path);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(0);
			HashMap<Double, String> mp = new HashMap<Double, String>();
			int RowCount = sheet.getLastRowNum();
			int ColCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(RowCount);
			System.out.println(ColCount);
			double Key=0;String Value="";
			for (int i=0;i<=RowCount;i++) {
				Row r = sheet.getRow(i);
				for(int j=0;j<ColCount;j++) {
					Cell c = r.getCell(j);
					if(c.getCellType() == CellType.NUMERIC) {
						Key = c.getNumericCellValue();
					}else if(c.getCellType() == CellType.STRING) {					
						Value = c.getStringCellValue();
					}
					mp.put(Key, Value);
				}
				
				
			}
			wb.close();
			fis.close();
			System.out.println(mp);
			

	}

}
