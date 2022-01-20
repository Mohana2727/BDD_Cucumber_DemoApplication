Feature: Verify SignOn functionality in OrangeHRM application

In order to test SignOn functionality
As a Tester
I want the OrangeHRM URL and and required valid credentials

Background: 

When User Launch the required OrangeHRM URL

@Functional
Scenario Outline: Verify SignIn functionality with credentials
  Given The user is in OrangeHRM application
  When He input the LoginName into Login Name field
  | LoginName | <User_Name> |
  And He input required password into Password field
  | password | <Password> |
  Then Click on Login button
  Then Application Navigates to Employee Information Page
    
  
  Examples:
  | User_Name | Password |
  | qaplanet1 | lab1 	 |



 