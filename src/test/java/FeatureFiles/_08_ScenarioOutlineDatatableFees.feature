#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee, delete Fee

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | fees |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>      |
      | codeInput       | <code>      |
      | integrationCode | <integration>|
      | priorityCode    | <priority>   |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <name> |

    And Success message should be displayed

    Examples:
      | name  | code | integration | priority |
      | met2314    | 510       | 214             | 219          |
      | met2315    | 519       | 214             | 219          |
      | met2316    | 518       | 214             | 219          |
      | met2317    | 516       | 214             | 219          |
      | met2318    | 511       | 214             | 219          |