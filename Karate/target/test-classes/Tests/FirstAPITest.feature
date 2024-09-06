Feature: API Testing using Karate

  Scenario: Create a Place
    Given url 'https://rahulshettyacademy.com/maps/api/place/add/json'
    And header Content-Type = 'application/json'
    And param key = 'qaclick123'
    And request read('payloadGoogleAPI.json')
    When method post
    Then status 200
    And print response
