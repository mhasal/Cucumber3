#Senaryo ;
  #1- siteyi açınız.
  #2- username ve password u gönderin ve login butonuna tıklatın.
  #3- login olduğunuzu doğrulayın.

    #- Sonra Yukarıdaki Senaryoyu Gherkin dilinde yazdık.


  Feature: Login Functionality

    Scenario: Login with valid username and password

    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
