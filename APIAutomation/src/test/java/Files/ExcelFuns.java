package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFuns {
	
	
	@Test
	public static void ExcelRead() throws IOException {
		FileInputStream Fi = new FileInputStream("C:\\Users\\swats\\Downloads\\StudentMarks.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(Fi);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		FileOutputStream Fo = new FileOutputStream("C:\\Users\\swats\\Downloads\\StudentMarks.xlsx");
		
	};

}
