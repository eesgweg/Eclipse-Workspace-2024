package JavaOOPs;



class Animal{
	public int a;
	Animal(int a){
		this.a = a;	
	}
	public void makesound(){
		System.out.println("Make a Sound!=---");
		System.out.println(a);
	}
}
public class Cat extends Animal{
	public static int a=300;
	Cat(){
		super(a);
	
	}
	
	public void makesound() {
		System.out.println("Bark");
		System.out.println(a);
	}
	public static void main(String[] args) {		
			Cat cat = new Cat();
			Animal animal = new Animal(100);
			cat.makesound();
			animal.makesound();
	}
	

}
