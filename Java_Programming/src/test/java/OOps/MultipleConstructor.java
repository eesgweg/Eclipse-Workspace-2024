package OOps;

public class MultipleConstructor {
	
	MultipleConstructor(){
		this(10);
		
		System.out.println("MultipleConstructor()");
	}
	
	MultipleConstructor(int a){
		this("mani");
		System.out.println(a);
	}
	
	MultipleConstructor(String a){
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		new MultipleConstructor();
	}

}
