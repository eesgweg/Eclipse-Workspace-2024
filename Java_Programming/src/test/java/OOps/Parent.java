package OOps;

public class Parent extends Grandfather{
	public String Parent_variable = "Parent_variable";
	public void Parent_method() {
		System.out.println("-----------------Parent_method start ---------------");
		System.out.println(Grandfather_variable);
		Grandfather_method();
		System.out.println("-----------------Parent_method end---------------");
		
	}
	
}
