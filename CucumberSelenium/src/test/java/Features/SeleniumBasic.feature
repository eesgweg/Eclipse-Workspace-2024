Feature: Testing the basic selenium functions
 Scenario: Testing Launch and RadioButton Click functionality					
 Given Browser is launched with Website
 When Radio Button is visible
 Then Click all radio buttons
 				| r1	| radio1 |
 			  | r2	| radio2 |
 				| r3	| radio3 |
 					
 And Verify WebTable Content
| Instructor   | Course                                                           | Price |
| Rahul Shetty | Selenium Webdriver with Java Basics + Advanced + Interview Guide | 30 |
| Rahul Shetty | Learn SQL in Practical + Database Testing from Scratch           | 25 |
| Rahul Shetty | Appium (Selenium) - Mobile Automation Testing from Scratch       | 30 |
| Rahul Shetty | WebSecurity Testing for Beginners-QA knowledge to next level     | 20 |
 And Close the Broswer
 