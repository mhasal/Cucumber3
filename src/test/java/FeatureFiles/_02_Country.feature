Feature: Country Functionality

  Scenario: Create Country
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Country Page
    When Create a Country
    Then Success message should be displayed