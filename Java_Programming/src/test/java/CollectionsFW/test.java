package CollectionsFW;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
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
		
		List<Integer> li = List.of(1,3,6,2,5,4,2,1);
//		Stream<Integer> stream = li.stream();
//		System.out.println(stream);
//		System.err.println("---- sorted().distinct()---------");
//		stream.sorted().distinct().forEach(System.out::println);
//		System.err.println("---- filter()---------");
//		li.stream().filter(n -> n%2 == 0).forEach(System.out::print);
//		 System.out.println();
//		System.err.println("---- peek() and limit(3)---------");
//		li.stream().peek(n ->  System.out.println("Peeking: "+n)).limit(3).forEach(System.out::println);
//        System.err.println("---- skip()---------");
//		li.stream().skip(3).forEach(System.out::println);
//		System.err.println("---- reduce()---------");		
//		int sum = li.stream().reduce(2,(a,b) -> a+b);
//		System.out.println(sum);		
//		Set<Integer> Convertedset =li.stream().collect(Collectors.toSet());
//		System.out.println("Convertedset: "+Convertedset);	
//		System.err.println(Convertedset.stream().allMatch(n -> n%2 == 0));
//		System.err.println(Convertedset.stream().anyMatch(n -> n%2 == 1));
//		System.err.println(Convertedset.stream().noneMatch(n -> n%5 == 0));
//		System.err.println("------ Map()---------");
//		Convertedset.stream().map(n -> n*2).forEach(System.out::println);
		
		
		int[] a = {1,2,3,4,5,6,7};
		List<Integer> al = new ArrayList<Integer>();
		for(int x :a) {
			al.add(x);
		}
		System.out.println(al);
		int k =2;
//		System.out.println(al.subList(k+1, al.size()));
//		System.out.println(al.subList(0, k+1));
		List<Integer> cl = Stream.concat(al.subList(k+1, al.size()).stream(), al.subList(0, k+1).stream()).collect(Collectors.toList());
		System.out.println(cl);
		
		
		
		
		
	}

	public void A() {

	}

	public void B() {

	}

	public void C() {

	}
}
