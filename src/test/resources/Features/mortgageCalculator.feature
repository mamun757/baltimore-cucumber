Feature: Mortgage Calculator

  @CalculateApr
  Scenario: Calculate Real APR Rate
    Given User is in mortgage calculator home page
    And user is navigate to Real Apr page
    When user clicks on calculate button upon entering the data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the real apr rate is "3.139%"