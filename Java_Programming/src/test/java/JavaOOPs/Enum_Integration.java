package JavaOOPs;

import org.testng.annotations.Test;

enum Browser {

	CHROME, FIREFOX, EDGE, SAFARI;

}

public class Enum_Integration {

	public void browserAsssignment(Browser browser) {
		switch (browser) {
		case CHROME:
			System.err.println("Assigning Chrome Browser");
			break;
		case FIREFOX:
			System.err.println("Assigning Firefox Browser");
			break;
		case EDGE:
			System.err.println("Assigning EdgeBrowser Browser");
			break;
		case SAFARI:
			System.err.println("Assigning Safari Browser");
			break;

		}
		
		
	}

	

}
