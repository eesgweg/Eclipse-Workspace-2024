package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class ReadersWritters {

	public static void main(String[] args) throws IOException {
		String filePathSource = "D:\\file.txt";
		String filePathTarget = "D:\\Targetfile.txt";
		String Target = "";
		// Initialize the BufferedReader
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathSource))) {
			String line;
			// Read the file line by line
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				Target += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathTarget))) {
			// Write lines of text to the file
			bufferedWriter.write(Target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
