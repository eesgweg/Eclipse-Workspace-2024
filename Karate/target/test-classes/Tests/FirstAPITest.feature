Feature: API Testing using Karate
 Background:
   * def BaseUrl = 'http://localhost:3000/Customers'
#		 # Fetch customer details and save ID
    #Given url 'http://localhost:3000/Customers'
    #And param customerId = 1
    #When method get
    #Then status 200
    #* def savedId = response[0].id
    #* print 'Saved ID:', savedId
    
  #Scenario: Get Customer Detail using UserID
  #	Given url 'http://localhost:3000/Customers/'+ savedId
  #	When method get
    #Then status 200
    #And print response   
    #And response.customerId=1
    #And response.name= "John Doe"
    #And response.email = "john.doe@example.com"
    #And response.phone = "555-1234"
    #And response.address.zip = "10001"
    #And response.accounts.balance = 5000.75
    
    
  Scenario Outline: Create New Customers, verify and Delete the Customer
  #Updating the Payload Request
  * def UpdatedPayload = karate.read("classpath:CustomersAPI.json")
  #* def UpdatedPayload = karate.get(payload)
  * UpdatedPayload.id= "Cstd"+<ID>
  * UpdatedPayload.customerId= <ID>
  * UpdatedPayload.name= "<Name>"
  * UpdatedPayload.email = "<Email>"
  * UpdatedPayload.phone = "<Phone>"
  * UpdatedPayload.address.zip = "<Zip>"
  #* UpdatedPayload.accounts.balance = 1000.00
  * print UpdatedPayload
  
  # Adding New customer
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
  #And response.accounts.balance = 1000.00
  * def NewUserID = response.id
  * print 'NewUserID:', NewUserID
  
  # Verify if new customer is added
  Given url BaseUrl
  When method get
  Then status 200
  And print response
  
  #* def responseArray = response.Customers
  * def lastindexofArray = response.length - 1
  * def lastElement = response[lastindexofArray]
  * match lastElement.id == NewUserID
  
  #Delete the Customer
  Given url BaseUrl +'/'+ NewUserID
  When method delete
  Then status 200
  And print response
  
  #Verify if customer is deleted
  Given url BaseUrl+'/'+NewUserID
  When method delete
  Then status 404
  And print response
  
  Examples:
  	| karate.read('classpath:TestData.csv') |
  
  
  
