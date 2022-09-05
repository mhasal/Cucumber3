#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.

  Feature: Employee Functionality

    Background:
      Given Navigate to basqar
      When Enter username and password and click login button
      Then User should login successfuly

    Scenario Outline: Create, Exist, Delete on Employee Page

      And Click on the element in the left Nav
        | humanResources |
        | employees      |

      And Click on the element in the Form Content
        | addButton |

      And User sending the keys in Form Content
        | firstName      | <firstName>      |
        | lastName       | <lastName>       |
        | empID          | <empID>          |
        | documentType   | Passport   |
        | documentNumber | <documentNumber> |
        | countrySelect  | <countrySelect>  |

      And Click on the element in the Dialog
        | saveButton |

      And Success message should be displayed



        Examples:
          | firstName  | lastName | empID   | documentNumber | countrySelect|
          | metin      | hasal    | 214213  |                |               |
       #  | metmet     | hasaa    | 2141323 |                |              |
       #  | mettem     | lahas    | 2143123 |                |               |
       #  | metinme    | lasah    | 214987  |                |              |
       #  | metinmme   | sahal    | 214312  |                |              |











