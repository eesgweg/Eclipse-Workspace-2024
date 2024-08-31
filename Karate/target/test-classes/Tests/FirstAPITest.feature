Feature: Test my First API Test script in Karate Framework

  Scenario: Test Positive Scenario
    Given url "https://reqres.in/api/users?page=2"
    When mehod GET
    Then status 200
