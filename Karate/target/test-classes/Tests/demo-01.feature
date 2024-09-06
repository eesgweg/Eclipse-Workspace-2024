Feature: browser automation 1

  Background:
    * configure driver = { type: 'chrome', showDriverLog: true }
  # * configure driverTarget = { docker: 'justinribeiro/chrome-headless', showDriverLog: true }
  # * configure driverTarget = { docker: 'ptrthomas/karate-chrome', showDriverLog: true }
  # * configure driver = { type: 'chromedriver', showDriverLog: true }
  # * configure driver = { type: 'geckodriver', showDriverLog: true }
  # * configure driver = { type: 'safaridriver', showDriverLog: true }
  # * configure driver = { type: 'iedriver', showDriverLog: true, httpConfig: { readTimeout: 120000 } }

  Scenario: try to login to github
  and then do a google search

    Given driver 'https://rahulshettyacademy.com/AutomationPractice/'
    When waitFor('#checkBoxOption1')
    Then click('#checkBoxOption1')
    And click('#checkBoxOption2')
    And input('#autocomplete','Hello Good Morning')
    Then quit()