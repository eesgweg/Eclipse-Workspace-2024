package Tests;

import org.junit.runner.RunWith;

import com.intuit.karate.junit5.Karate;


public class TestRunner{
	 @Karate.Test
	    Karate testAll() {
	        return Karate.run("classpath:Tests").relativeTo(getClass());
	    }
}
