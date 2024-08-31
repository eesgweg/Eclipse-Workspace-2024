Feature: Validate Transactions
Scenario: Fetch API Key
Given Base URL
When User calls "GenerateNewAPIKey" request
Then Validate Status code 200
And save APIKey

Scenario: Create Account
Given Account Details Payload
When User calls "CreateAccountAPI" request
Then Validate Status code 200
And save AccountID