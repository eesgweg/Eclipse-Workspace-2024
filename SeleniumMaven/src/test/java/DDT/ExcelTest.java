package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelTest {

	public ArrayList<String> getdatafromexcel(String sheetname, String Headertostart) throws IOException {
		boolean flag;
		ArrayList<String> data = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\swats\\OneDrive\\Desktop\\Study\\PS.xls");
		// TODO Auto-generated method stub
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		int sheetcount = wb.getNumberOfSheets();
		System.err.println("----------Identifying the Column header we are going to work on---------------");
		for(int i=0;i<sheetcount;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				 flag = true;
				 HSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
//			Row Firstrow = rows.next();
//				Iterator<Cell> cell =Firstrow.cellIterator();
				int k=0,column=0;
//				while(cell.hasNext()) {
//					Cell value = cell.next();
//					if(value.getStringCellValue().equalsIgnoreCase(Headertostart)) {
//						flag = true;
//						column=k;
//					}
//					k+=1;
//				}
//				System.out.println(column);
//				System.out.println(flag);
//				 k=0;
				 while(rows.hasNext()) {
					 Row r = rows.next();
					 if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Headertostart));{
						 flag=true;
						 System.out.println(flag);
						Iterator<Cell> cv=  r.cellIterator();
						while(cv.hasNext()){
							Cell c = cv.next();
							if(c.getCellType() == CellType.STRING) {
								System.out.println(c.getStringCellValue());
								data.add(c.getStringCellValue());
							}else if(c.getCellType() == CellType.NUMERIC) {
								System.out.println(c.getNumericCellValue());
								
								data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
						 
					 }
				 }
			}
		}
		wb.close();
	//	System.out.println(data);
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		ExcelTest ExcelTest = new ExcelTest();
		System.out.println(ExcelTest.getdatafromexcel("testdata","Customer Name"));
	}

}
