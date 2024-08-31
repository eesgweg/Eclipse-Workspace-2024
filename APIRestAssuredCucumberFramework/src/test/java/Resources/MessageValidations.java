package Resources;
//Enum is special class in java which has collection of constants/Methods
public enum MessageValidations {
	CreateProductSuccessMessage("Product Added Successfully"),
	DeleteProductSuccessMessage("Product Deleted Successfully");
	
	private String Message;
	
	MessageValidations(String Message) {
		
		this.Message=Message;
		
	}
	public String getResource() {
		
		return Message;
	}
	
	
	
	
	
}
