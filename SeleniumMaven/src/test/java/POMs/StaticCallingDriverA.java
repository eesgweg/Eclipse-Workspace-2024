package POMs;

public class StaticCallingDriverA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDriverClass.DriverAssignment();
		StaticDriverClass.driver.get("https://"
				+ "jsoneditoronline.org");
	}

}
