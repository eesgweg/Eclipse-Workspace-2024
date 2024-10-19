package JavaOOPs;

class GrandMaster{
	 GrandMaster(){
		 System.out.println("GrandMaster Constructor");
	 }
	 
	 GrandMaster(int a){
		 System.out.println("GrandMaster 1 -"+a);
	 }
	 
	 GrandMaster(String a, String b){
		 System.out.println("GrandMaster 2 -"+a+" "+b);
	 }
}

 class Master extends GrandMaster{
	 Master(){
		 System.out.println("Master Constructor");
	 }
	 
	 Master(int a){
		 System.out.println("Master 1 -"+a);
	 }
	 
	 Master(String a, String b){
		 System.out.println("Master 2 -"+a+" "+b);
	 }
 }

public class Base extends Master{

	private Base(){
		System.out.println("Constructor");
	}
	
	Base(int a){
		super("y","p");
		System.out.println(a);
	}
	
	Base(String a, String b){
		super(99);
		System.out.println(a+" "+b);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Mani");
		Base b = new Base();
		Base b1 = new Base(7);
		Base b2 = new Base("a","h");
		
		Master m = new Master();
		Master m1 = new Master(7);
		Master m2 = new Master("a","h");
		
		GrandMaster gm = new GrandMaster();
		GrandMaster gm1 = new GrandMaster(7);
		GrandMaster gm2 = new GrandMaster("a","h");
	}

}
