Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: States testing with JDBC
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | states     |

    Then Send The Query the Database "select * from states" and control match