Feature: Validating Place APIs
@AddPlace @Regression
Scenario Outline: Verify if place is successfully added using AddPlace API
	Given Add place Payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with "POST" http Request
	Then the API call is successful with status code is 200
	And "status" in response body should be "OK"
	And "scope" in response body should be "APP"
	And Verify if Place_ID is added successfuly for "<name>" using "GetPlaceAPI"
	
Examples:
	|name | language | address 		 |
	|ZDog	| ZTamil	 | London Street|
#	|BDog	| BTamil	 | Child Street|
#	|CDog	| CTamil	 | ABC Street|

@DeletePlace
Scenario: Verify DeletePlaceAPI
	Given Delete API Payload
	When User calls "DeletePlaceAPI" with "DELETE" http Request
	Then the API call is successful with status code is 200
	And "status" in response body should be "OK"