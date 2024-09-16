Feature: Get Users
  Scenario: Get Users
    Given url 'https://api.getpostman.com/collections'
    And header X-API-Key = 'PMAK-66d3d47f1e5c5900010c7343-2de06fdb7de816c3270e681139b77660a3'
    When method get
    Then status 200
    And print response    
    * def ArraySize = response.collections.length
    * print ArraySize