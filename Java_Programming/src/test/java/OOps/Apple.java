package OOps;

public class Apple implements Mobile,Space{

	@Override
	public void Size() {
		// TODO Auto-generated method stub
		System.out.println("6 inch screen");
	}

	@Override
	public void Camera() {
		// TODO Auto-generated method stub
		System.out.println("12 MP");
	}

	@Override
	public void software() {
		System.out.println("IOS");
		
	}
	
	public static void main(String[] args) {
		System.out.println("When you create an object of Apple and assign it to a reference variable of an interface type, you achieve polymorphic behavior.");
		Mobile Apple = new Apple();
		Apple.Size();
		Apple.Camera();
		Apple.software();
		
		Space c = new Apple();
//		c.Space_method();
	}

	//@Override
//	public void Space_method() {
//		System.out.println("Space methof");
//		
//	}

}
