package OOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class pracs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner scanner = new Scanner(System.in);
//
//        // Read a string input
//        System.out.print("Enter Number: ");
//        String n = scanner.nextLine();
        
//		int n = 5;
//		
//		 for (int i = 1; i <= n; i++) {
//	            for (int j = i; j < n; j++) {
//	                System.out.print(" "); // Print spaces
//	            }
//	            for (int k = 1; k <= (2 * i - 1); k++) {
//	                System.out.print("*"); // Print stars
//	            }
//	            System.out.println();
//	        }
	
		//Second Largest in array
		int[] aarray = {1,2,10,9,3};
		
		Arrays.sort(aarray);
		System.out.println("The Second Largest Number in the Array is "+aarray[aarray.length-2]);
		
	
		
		//Duplicate chars in string
		String a ="My God is so good and wonderful";
		Set<Character> constants = new HashSet<Character>();
		Set<Character> duplicates = new HashSet<Character>();
		for(char x : a.toCharArray()){
			if(constants.contains(x)){
				duplicates.add(x);
			}else{
				constants.add(x);
			}
		}
		System.out.println("Set of Unique Values: "+constants);
		System.out.println("Set of Duplicate Values: "+duplicates);
        
        
	}

}
