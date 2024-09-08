Feature: Save ID of the Customer
	Scenario:   
#	  Fetch customer details and save ID
    Given url 'http://localhost:3000/Customers'
    And param customerId = 306
    When method get
    Then status 200
    * def savedId = response[0].id
    * print 'Saved ID:', savedId
    * def CustomerID = response[0].customerId
    