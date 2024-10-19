package API;

import io.restassured.response.Response;

public interface RESTHTTPRequest {
	
	public Response GetRequest(String Resource);
	public Response PostRequest(String Resource,String Requestbody);
	public Response PutRequest(String Resource,String Requestbody);
	public Response PatchRequest(String Resource,String Requestbody);
	public Response DeleteRequest(String Resource);

}
