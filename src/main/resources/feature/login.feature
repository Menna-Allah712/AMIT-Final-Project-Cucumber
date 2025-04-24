
Feature: Login Feature
  Scenario: Login with valid credentials
    Given user open homepage & click on login button
    When user enters username & password & press on login button
    Then user is switched to loginAlert & success message appear
