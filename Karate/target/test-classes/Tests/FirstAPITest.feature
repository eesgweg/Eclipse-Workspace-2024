Feature: API Testing using Karate
 Background:
   * def BaseUrl = 'http://localhost:3000/Customers'
   * def result = call read('classpath:Tests/SaveID.feature')
   * def savedId = result.savedId
   * def CustomerID = result.CustomerID
   * print 'ID : ',savedId
   * print 'CustomerID: ',CustomerID
    
  Scenario: Get Customer Detail using UserID
  	Given url 'http://localhost:3000/Customers/'+ savedId
  	When method get
    Then status 200
    And print response
    And response.customerId == '#notnull'
    And response.customerId=CustomerID
    And response.customerId == '#regex ^[a-z]{4}[0-9]{3}$'
    And match response contains {"name": "DDDD"}
    #And match response.accounts[0].transactions[0].description in ['Paycheck deposit', 'ATM withdrawal']
    And match response.accounts[0].transactions[0].amount == '#number' 
    And match response.accounts[0].transactions[0].type == '#string'
    And match response !contains {"name": "XXXXX"}
    * def KarateGet = karate.get("CustomerID")
    * print 'KarateGet - CustomerID: ',KarateGet
    * def KarateSet = karate.set("CustomerID",0)
    * print 'KarateSet - CustomerID: ',CustomerID
    * def ResponsePrettyprint = karate.pretty(response)
    * print ResponsePrettyprint
    * def type = karate.typeOf(CustomerID)
    * print type
    * def StringCustomerID = karate.to('string',CustomerID)
    * print StringCustomerID


    #And response.email = "john.doe@example.com"
    #And response.phone = "555-1234"
    #And response.address.zip = "10001"
    #And response.accounts.balance = 5000.75
    
    
  Scenario Outline: Create New Customers, verify and Delete the Customer
  Updating the Payload Request
  * def UpdatedPayload = karate.read("classpath:CustomersAPI.json")
  * def UpdatedPayload = karate.get(payload)
  * UpdatedPayload.id= "Cstd"+<ID>
  * UpdatedPayload.customerId= <ID>
  * UpdatedPayload.name= "<Name>"
  * UpdatedPayload.email = "<Email>"
  * UpdatedPayload.phone = "<Phone>"
  * UpdatedPayload.address.zip = "<Zip>"
  * UpdatedPayload.accounts.balance = 1000.00
  * print UpdatedPayload
  
   Adding New customer
  Given url BaseUrl
  And request UpdatedPayload
  When method post
  Then status 201
  And print response
  And response.id = "Cstd"+<ID>
  And response.customerId=<ID>
  And response.name= "<Name>"
  And response.email = "<Email>"
  And response.phone = "<Phone>"
  And response.address.zip = "<Zip>"
  And response.accounts.balance = 1000.00
  * def NewUserID = response.id
  * print 'NewUserID:', NewUserID
  
   Verify if new customer is added
  Given url BaseUrl
  When method get
  Then status 200
  And print response
  * def responseContent = response
  * def filePath = karate.write(responseContent, 'target/output/response-files/user-response.json')
  * print 'Response saved to file:', filePath
  
  
  * def responseArray = response.Customers
  * def lastindexofArray = response.length - 1
  * def lastElement = response[lastindexofArray]
  * match lastElement.id == NewUserID
  
  Delete the Customer
  Given url BaseUrl +'/'+ NewUserID
  When method delete
  Then status 200
  And print response
  
  Verify if customer is deleted
  Given url BaseUrl+'/'+NewUserID
  When method get
  Then status 404
  And print response
  
  Examples:
  	| karate.read('classpath:TestData.csv') |
  
  
  
