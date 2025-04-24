@Regression
Feature: Signup Feature
  Scenario: Signup successful
    Given user open home page & click on signup button
    When user enters username & password & press on signup button
    Then user is switched to signupAlert & success message appear

   Scenario Outline: signup with existing username
     Given user open home page & click on signup button
     When user enters exist "<username>" & "<password>" & press on signup button
     Then user is switched to signupAlert & error message appear
     Examples:
       |username  |password|
       |Menna7    |123!    |
