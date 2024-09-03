package Utlilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import org.testng.annotations.Test;

public class Utlility {
	Properties prop;
	
	public String Encode(String a) {	
		return Base64.getEncoder().encodeToString(a.getBytes());	
	}
	
	public String Decode(String a) {
		byte[] decodedBytes = Base64.getDecoder().decode(a);
		return new String(decodedBytes);
	}
	
	public String Getproperty(String Property) throws IOException {
		 prop = new Properties();
		FileInputStream Fis = new FileInputStream("C:\\Users\\swats\\Mani Eclipse New Workspace\\SeleniumMaven\\src\\main\\java\\Properties.properties");
		prop.load(Fis);
		String a = null;
		
		for(String x : prop.stringPropertyNames()) {
			if(Property.toUpperCase().equals(x))
			 a = prop.getProperty(x);
		}
		System.out.println(a);
		return a;
	}
	
	@Test
	public void Runner() throws IOException {
		Getproperty("URL");
		Getproperty("userid");
		Getproperty("password");
	}

}
