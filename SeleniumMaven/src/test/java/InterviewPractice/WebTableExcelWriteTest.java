package InterviewPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableExcelWriteTest {
	
	public static void WriteWebTableToExcel(String File,List<List<String>> data) throws IOException {
		FileInputStream fis = new FileInputStream(File);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet;
		if(wb.getSheetIndex("NEW")==-1) {
			 sheet = wb.createSheet("NEW");	
		}else {
			 sheet = wb.getSheet("NEW");
		}
		int RowCount = data.size();
		int Columncount= data.get(0).size();
		for(int i=0;i<RowCount;i++) {
			sheet.createRow(i);
			for(int j=0;j<Columncount;j++) {
				sheet.getRow(i).createCell(j).setCellValue(data.get(i).get(j));
			}
			
		}
		
		
		FileOutputStream fos = new FileOutputStream(File);
		wb.write(fos);
		wb.close();
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","G:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///G:/HTMLPAGE.html");
		List<List<String>> data = new LinkedList<List<String>>();
		WebElement Table =driver.findElement(By.xpath("//*[text()='5x5 Web Table']//following::body//following::table//tbody"));
		WebElement Tableheader = driver.findElement(By.xpath("//*[text()='5x5 Web Table']//following::body//following::table//thead"));
		//Headers
		List<WebElement> Headers = Tableheader.findElements(By.tagName("tr"));
		System.out.println(Headers.size());
		
		for(WebElement h : Headers) {
			List<WebElement> HeaderColumns = h.findElements(By.tagName("th"));
			List<String> HeaderColumnData = new LinkedList<String>();
			for(WebElement ch : HeaderColumns) {
				System.out.print("| "+ch.getText().trim().toUpperCase()+" |");
				HeaderColumnData.add(ch.getText().trim().toUpperCase());
			}
			data.add(HeaderColumnData);
		}
		
	
		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
		int NoofRows = Rows.size();
		System.out.println(NoofRows);
		for(WebElement r : Rows) {
			List<WebElement> Columns = r.findElements(By.tagName("td"));
			List<String> ColumnsData = new LinkedList<String>();
			for(WebElement c : Columns) {
				System.out.print("| "+c.getText().trim().toUpperCase()+" |");
				ColumnsData.add(c.getText().trim().toUpperCase());
			}
			System.out.println();
			data.add(ColumnsData);
			System.out.println(data);
			
		}
		
		WriteWebTableToExcel("G:\\A.xls",data);
		driver.quit();
		
		
	}
	
	
	
}
