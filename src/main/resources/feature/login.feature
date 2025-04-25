
Feature: Login Feature

  Scenario Outline: Login with valid credentials
    Given user open homepage & click on login button
    When the user attempts to log in with username "<username>" and password "<password>"
    Then user is switched to loginAlert & success message appear
    Examples:
      | username | password |
      | Menna14  | 123      |

  Scenario Outline: Login with invalid credentials
    Given user open homepage & click on login button
    When the user attempts to log in with username "<username>" and password "<password>"
    Then the user should see an alert message Wrong password.
    Examples:
      | username | password |
      | Menna14  | 12345    |