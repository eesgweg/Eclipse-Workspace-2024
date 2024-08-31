package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testclass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties Prop = new Properties();
		FileInputStream fis = new FileInputStream(
					"C:\\Users\\swats\\Mani Eclipse New Workspace\\APIRestAssuredCucumberFramework\\src\\test\\java\\Resources\\globalnew.properties");
			Prop.load(fis);	
		System.out.println(Prop.getProperty("UserName"));
		System.out.println(Prop.getProperty("pwd"));
	}

}
