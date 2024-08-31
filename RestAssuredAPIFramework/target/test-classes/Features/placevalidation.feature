Feature: Validating Place APIs
Scenario Outline: Verify if place is successfully added using AddPlace API
	Given Add place Payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with POST http Request
	Then the API call is successful with status code is 200
	And "status" in response body should be "OK"
	And "scope" in response body should be "APP"
	
Examples:
	|name | language | address 		 |
	|ADog	| ATamil	 | Royal Street|
	|BDog	| BTamil	 | Child Street|
	|CDog	| CTamil	 | ABC Street|
	