package FactoryClassExp;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class Runner {
	@Factory
	public Object[] factoryMethod(String browser) {
        return new Object[] {
            new A(browser),
            new B(browser),
            new C(browser)
        };
}	
	
	
	@DataProvider(name = "browser")
	public Object[][] browserData(){
		return new Object[][] {
			{"Chrome"},{"Firefox"},{"Edge"}
		};
		
		}
	

@Test(dataProvider = "browserData")
public void Run(String browser) {
	factoryMethod(browser);
}
}


