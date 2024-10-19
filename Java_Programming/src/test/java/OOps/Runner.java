package OOps;

public class Runner {

	public static void main(String[] args) {
//	Child Child = new Child();
//	Child.Grandfather_method();
//	System.out.println(Child.Grandfather_variable);
//	Child.Parent_method();
//	System.out.println(Child.Parent_variable);
//	Child.child_method();
//	System.out.println(Child.child_variable);

		System.err.println("---- strings-------------");
		String a = "Mani@123i23";
		System.out.println("The Length of the String: "+ a.length());
		System.out.println("The Concatination String: "+a.concat("AAAAAA"));
		System.out.println("The Character at Index 4 of the String: "+a.charAt(4));
		System.out.println("The Index of the Character '@' in the  String: "+a.indexOf('@'));
		System.out.println("The Index of the SubString in the String: "+a.indexOf("123"));
		System.out.println("The LastIndex of the Character in the String: "+ a.lastIndexOf('i'));
		System.out.println("The LastIndex of the Substring in the String: "+ a.lastIndexOf("23"));
		System.out.println("Substring from index 4: "+a.substring(4));
		System.out.println("Substring from index 0th to 3rd index: "+a.substring(0, 4));
		System.out.println("String to Lowercase: "+a.toLowerCase() + " - \n String to Uppercase" + a.toUpperCase());
		System.out.println("Replace 123 with 000 in the String: "+a.trim().replace("123", "000"));
		System.out.println("Replace @ with % in the String: "+a.trim().replace('@', '%'));
		String[] words = a.split("@"); // Split the String USing delimeter to array
		for (String word : words) {
			System.out.println(word);
		}
		String c= String.join(", ", words); // Joins the Array String to a String
		System.out.println("Joint String from Array: "+c);
		String reverse_a = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			System.out.println(a.charAt(i));
			reverse_a = reverse_a + a.charAt(i);
		}
		System.out.println("Reverse of the String: "+reverse_a);
		System.out.println("String Equals boolean Value: "+ ("Mani".equals("Mani")));
		System.out.println("String EqualsIgnoreCase boolean Value: "+ ("MaNIf".equalsIgnoreCase("Manif")));
		System.out.println("String CompareTo boolean Value: "+ ("Mani".compareTo("Mani")));
		System.out.println("String Contains @123 Boolean Value: "+a.contains("@123"));
		System.out.println("String IsEmpty Boolean Value: "+("".isEmpty()));

		
		System.err.println("---------StringBuffer-------------");
		StringBuffer b = new StringBuffer("Bharathi @123");
		System.out.println(b.capacity());
		b.append('A');
		System.out.println(b);
		b.replace(0, 4, "Mani");
		System.out.println(b);

// 1 Dimensional Array
	System.err.println("------- 1 Dimensional Array ----------");
	int[] ArrayA= {1,2,4,6,8};
	System.out.println(ArrayA.length);
	for(int i=0;i<ArrayA.length-1;i++) {
		System.out.println(ArrayA[i]);
	}
		
//	2 Dimensional Array
	System.err.println("------- 2 Dimensional Array ----------");
	int ArrayB[][]= {ArrayA,{4,5,6}};
	for(int r=0;r<ArrayB.length;r++) {
		for(int z=0;z<ArrayB[r].length;z++) {
			System.out.print(ArrayB[r][z]);
		}
		System.out.println();
	}

	}

}
