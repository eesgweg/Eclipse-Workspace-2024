Feature: Ecommerce Create and Delete Product Functionality
Scenario: Login using Valid User credentials
Given Login Payload with "Valid" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 200
And Fetch TokenID and UserID
And Validate message

Scenario: Create New product and verify if created successfully
Given "Laptop" product details to be added
When User calls "EcommerceCreateProductResourceAPI" with "POST" request
Then Validate Status code is 201
And Fetch ProductID
And Validate message

Scenario: Create a Order for the Product
Given CreateOrder Payload
When User calls "EcommerceCreateOrderResourceAPI" with "POST" request
Then Validate Status code is 201
And Fetch OrderID
And Validate message

Scenario: Verify if order placed successfully in the Portal and Delete the Placed Order
Given Successfully logging into portal
When User Navigates to Orders Tab
Then Validate OrderID
Then Validate OrderDetails
Then Delete Order in UI

Scenario: Delete Added product and verify if Deleted successfully
Given "Laptop" product details to be Deleted
When User calls "EcommerceDeleteProductResourceAPI" with "DELETE" request
Then Validate Status code is 200
And Validate message