package OOps;

public class Child extends Parent{
	public String child_variable = "child_variable";
	public void child_method() {
		System.out.println("-----------------Child_method start ---------------");
		System.out.println(Parent_variable);
		Parent_method();
		System.out.println("-----------------child_method end---------------");
		
		
	}
}
