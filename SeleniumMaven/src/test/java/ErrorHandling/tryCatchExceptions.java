package ErrorHandling;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tryCatchExceptions {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Trying");
//			assertEquals(false, true); //AssertionError = Not catchable
//			Integer.parseInt("acv"); //NumberFormatException
			//ConcurrentModificationException
//			List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); 
//			for (String s : list) 
//			{
//				list.add("d"); 
//			}
			//ClassCastException
//			 int[] arr = new int[5]; int val = arr[10];
			// Object obj = new Integer(100); String str = (String) obj;
//			 FileReader reader = new FileReader("nonexistentfile.txt");
		
		}catch (AssertionError e) {
			System.out.println("Caught");
			System.out.println(e);
		}catch (RuntimeException e) {
			System.out.println("Caught");
			System.out.println(e);
		}
		finally {
			System.out.println("Finally");
		}
		
	}

}
