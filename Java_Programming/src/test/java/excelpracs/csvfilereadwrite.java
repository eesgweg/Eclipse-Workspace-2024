package excelpracs;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class csvfilereadwrite {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		String path = "G:\\CSV.csv";
		CSVReader CSVReader = new CSVReader(new FileReader(path));
		 String[] line;
		while(CSVReader.readNext() != null) {
			line= CSVReader.readNext();
			for(String x : line) {
				System.out.print(x);
			}
			System.out.println();
		}
		CSVReader.close();
	}

}
