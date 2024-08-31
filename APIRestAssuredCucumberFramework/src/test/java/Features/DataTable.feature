@Mani
Feature: Testing DataTable
	Scenario: Testing Valid Datatable
		Given I have the below Values:
		  | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
		When Post request is sent
		Then verify status code 200
		 
