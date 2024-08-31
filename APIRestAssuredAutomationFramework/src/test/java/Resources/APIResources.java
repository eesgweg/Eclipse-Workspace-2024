package Resources;
//Enum is special class in java which has collection of constants/Methods
public enum APIResources {

	AddPlaceAPI("maps/api/place/add/json"),
	DeletePlaceAPI("maps/api/place/delete/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	UpdatePlaceAPI("maps/api/place/update/json");
	private String Resource;
	
	APIResources(String Resource) {
		
		this.Resource=Resource;
		
	}
	public String getResource() {
		
		return Resource;
	}
	
	
	
	
	
}
