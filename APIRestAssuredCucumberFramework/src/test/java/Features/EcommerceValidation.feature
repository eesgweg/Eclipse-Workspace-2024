Feature: Ecommerce Login Functionality
Scenario: Login using Valid User credentials
Given Login Payload with "Valid" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 200
And Fetch TokenID and UserID
And Validate message

Scenario: Login using InValid UserID
Given Login Payload with "InvalidUserID" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 400
And Validate message

Scenario: Login using InValid Password
Given Login Payload with "InvalidPassword" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 400
And Validate message

Scenario: Login using Null UserID
Given Login Payload with "NoUserID" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 400
And Validate message

Scenario: Login using Null Password
Given Login Payload with "NoPassword" User credentials
When User calls "EcommerceLoginResourceAPI" with "POST" request
Then Validate Status code is 400
And Validate message

