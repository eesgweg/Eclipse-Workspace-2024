package Resources;
//Enum is special class in java which has collection of constants/Methods
public enum APIResources {

	AddPlaceAPI("maps/api/place/add/json"),
	DeletePlaceAPI("maps/api/place/delete/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	UpdatePlaceAPI("maps/api/place/update/json"),
	EcommerceLoginResourceAPI("api/ecom/auth/login"),
	EcommerceCreateProductResourceAPI("api/ecom/product/add-product"),
	EcommerceDeleteProductResourceAPI("api/ecom/product/delete-product"),
	EcommerceCreateOrderResourceAPI("api/ecom/order/create-order"),
	TransactionsBaseURL("https://template.postman-echo.com"),
	GenerateNewAPIKey("/api/v1/auth"),
	CreateAccountAPI("/api/v1/accounts");
	private String Resource;
	
	APIResources(String Resource) {
		
		this.Resource=Resource;
		
	}
	public String getResource() {
		
		return Resource;
	}
	
	
	
	
	
}
