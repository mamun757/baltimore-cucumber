Feature: Test Login Functionalities

  Background:
    Given a user is on the login page

  @positive_test
 Scenario: Check login is successful with valid credentials
    When user enters username "Mamun" and password"12345"
    And click on the login button
    Then user is navigate to home page

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials
    When user enters username "<username>" and password"<password>"
    And click on the login button
    Then user is navigate to home page

    Examples:
    |username|password|
    |Mamun   |12345   |
    |Rifat   |12345   |
    |Robert  |12345   |
    |Mofiz   |12345   |

@negative_test
  Scenario: Check login is unsuccessful with Invalid credentials
    When user enters username "Mamun" and password"22222"
    And click on the login button
    Then user is failed to login

  @dataDriven_test
  Scenario: Check login is successful with valid credentials using data table
    When user click on login button upon entering credentials
    |username|password|
    |Rifat   |12345   |
    Then user is navigate to home page




