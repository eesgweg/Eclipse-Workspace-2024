package CollectionsFW;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";

	public static void main(String[] args) {
//		Class<?> clazz = Collections_Framework.class;
//        Method[] methods = clazz.getDeclaredMethods();
//        List<Method> Methods = new ArrayList<Method>();
//        for(Method method : methods) {
//        	if (!method.getName().contains("$")) {
//        		System.out.println(method.getName());
//            }
//        }

//		Matcher matcher;
//		Pattern CompiledPattern;
//		List<String> MailIDs = new ArrayList<String>();
//		MailIDs.add("rainamani.444@gmail.com");
//		MailIDs.add("abc123gmail.com");
//		MailIDs.add("swatsmani.1110@gmail.com");
//		String ptrn = "@gmail.com";
//		CompiledPattern = Pattern.compile(ptrn);
//
//		for (String x : MailIDs) {
//			matcher = CompiledPattern.matcher(x);
//			if(matcher.find()) {
//				System.out.println(matcher.start() + " : " + matcher.end());
//			}
//
//		}

//		List<String> names = Arrays.asList("Sara", "John", "Paul");
//		// API Stream For Each
//		names.forEach(name -> System.out.println(name));
//		names.stream().limit(names.size()).forEach(name -> {
//			System.out.println(name);
//		});
//
//		HashMap<Integer, String> mp = new HashMap<Integer, String>();
//		mp.put(1, "BLUE");
//		mp.put(2, "RED");
//		mp.put(3, "GREEN");
//		mp.forEach((k, v) -> {
//			if (v.contains("B")) { // Check if the value (String) contains "B"
//				System.out.println(k + " : " + v); // Print key and value
//			}
//		});
//		
//		// API Stream - Filter
//		names.stream().filter(n -> n.contains("a")).forEach(n -> System.out.println(n + " is 'A' category"));
//		
//		//API Stream - Map
//		names.stream().map(n -> n+"_AAA").forEach(n -> System.out.println(n));
//		names.stream().filter(n -> n.contains("a")).map(n -> n+"_AAA").forEach(n -> System.out.println(n));
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First number:");
		String s1 = scanner.nextLine();
		System.out.println("Enter Second Word:");
		String s2 = scanner.nextLine();
		System.out.println(s1+s2);
		
		
		
		
	}

	public void A() {

	}

	public void B() {

	}

	public void C() {

	}
}
