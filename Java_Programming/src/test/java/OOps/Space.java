package OOps;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Space {
	public static void main(String[] args) {
		
//		String a ="Hi hello how are you!!";
//		System.out.println(a.length());
//		System.out.println(a.substring(2));
//		System.out.println(a.substring(2,22));
		List<Character> li = new ArrayList<Character>();
//		Map<Integer,Character> map = new LinkedHashMap<Integer,Character>();
//		int i =0;
//		
//		for(char c : a.toCharArray())
//		{
//			li.add(c);
//			if(Character.isUpperCase(c)) {
//				System.out.println("uppercase: "+c);
//			}
//			i++;
//			map.put(i, c);
//		}
//		System.out.println(li);
//		Set<Character> set = new TreeSet<Character>(li);
//		System.out.println(set);
//		System.out.println(map);
//		
		int n=5;
//		int First =0, second =1;
//		for(int i=0;i<n;i++) {
//			System.out.print(First+" ");
//			int next =First+second;
//			First=second;
//			second=next;
//		}
//		
		
		//Stream.concat(li.subList(0, n), li.subList(n, li.size())).collect(Collectors.toList());
		
		for(int i=n;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
				}
	}
