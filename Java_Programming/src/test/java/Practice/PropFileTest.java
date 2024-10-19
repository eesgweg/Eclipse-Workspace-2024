package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

public class PropFileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			System.out.println("Hi");
//			Properties prop = new Properties();
//			FileInputStream fis = new FileInputStream("C:\\Users\\swats\\Mani Eclipse New Workspace\\Dummy\\src\\Practice\\global.properties");
//			prop.load(fis);
//			System.err.println(prop.get("BaseUrl"));
//			prop.load(fis);
//			System.err.println(prop.get("UserID"));
//			prop.load(fis);
//			System.err.println(prop.get("Password"));
//			System.err.println(prop.get("UserID2"));
//			------------------------------------------------------------------------------
//			StringBuffer sb = new StringBuffer();
//			sb.append("Mani");
//			System.err.println(sb);
//			sb.insert(2, '0');
//			System.err.println(sb);
//			System.out.println(sb.reverse()+" of length: "+sb.length()+" replace 0 with 1: "+sb.replace(0, 4, "9"));
//			System.err.println(sb);
//			System.out.println(sb.charAt(0));
//			sb.setLength(10);
//			System.out.println(sb+" : "+sb.length());
//	
//			String a = "Mani";
//			System.out.println(a.charAt(0));
//			System.out.println("String Replace doesnt change the orginal Value:");
//			a.replace("M", "H");
//			System.out.println(a);
//			System.out.println("So strings are Immutable");
//			System.out.println("Stringbuffer Replace changes the orginal Value:");
//			sb.replace(0, 1, "JS");
//			System.out.println(sb);
//			System.out.println("So stringbuffer are Mutable");
			
//			------------------------------------------------------------------------------
//			
//			@SuppressWarnings("deprecation")
//			URL URL = new URL("https://rahulshettyacademy.com/brokenlink");
//			HttpURLConnection c = (HttpURLConnection) URL.openConnection();
//			c.connect();
//			System.out.println(c.getResponseCode());
//			System.out.println(c.getResponseMessage());
//			HttpsURLConnection hc = (HttpsURLConnection) URL.openConnection();
//			hc.connect();
//			System.out.println(hc.getResponseCode());
//			System.out.println(hc.getResponseMessage());
//			------------------------------------------------------------------------------
			
			String a="Manish";
			System.out.println(a.matches("M(.*)"));
			//here we are checking if String a starts with M o not
			
			System.out.println(a.matches("(.*)x"));
			//here we are checking if String a ends with h o not

			System.out.println(a.equals("Manish"));
			//here we are checking if String a is same as Manish

			System.out.println(a.equalsIgnoreCase("manish"));
			//here we are checking if Manish is same as manish[if we ignore its upper and lower case]

			System.err.println(a.contains("ish"));
			//here we are checking if String a have "ish" or not in it
			
			
			System.err.println(Arrays.toString(a.toCharArray()));
			
			
			
	}

}
