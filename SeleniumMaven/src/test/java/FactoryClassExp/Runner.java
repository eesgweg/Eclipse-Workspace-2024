package FactoryClassExp;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;



public class Runner {
	@Factory
	public Object[] factoryMethod() {
        return new Object[] {
            new A(1),
            new B(2),
            new C(3)
        };
}	
	@Test
	public void run() {
		Map<Integer, Object> a = new HashMap<Integer, Object>();
		int i = 0;
		for(Object x : factoryMethod()) {
			System.out.println(x);
			a.put(i, x);
			i++;
		}	
		
		System.out.println(a);
	}
}

