@Regression
Feature: Calcs
	Background:
			Given User is authenticated
			// deal properties

  @R1
  Scenario: Addition
    Given I have 2 values
      | value1 | value2 |
      |      5 |      5 |
      |      7 |      2 |
    When I add them
    Then validate the SUM
    And check if its a odd or even

  @R2
  Scenario Outline: Title of your scenario outline
    Given I have 2 values <value1> and <value2>
    When I add them
    Then validate the SUM
    And check if its a odd or even

    Examples: 
      | value1 | value2 |
      |      5 |      5 |
      |      7 |      2 |
