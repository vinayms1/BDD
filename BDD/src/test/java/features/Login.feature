Feature: Login feature for vtiger application

  Background: 
    Given i will launch browser
    And enter the url "http://localhost:8888/"

  @SmokeTest
  Scenario: i want login to the application with valid creadentials
    When Login page is displayed and i will enter username and password
    And click on login button
    Then i will check it will navigating to home page or not

  @SmokeTest
  Scenario: i want login to the application with valid user name and password
    When Login page is displayed and i will enter username "admin" and password "admin"
    And click on login button
    Then i will navigate it will navigating to home page or not

  @RegressionTest
  Scenario Outline: i want login to the application with invalid user name and password
    When Login page is displayed and i will enter username "<userName>" and password "<Password>"
    And click on login button
    Then i will check whether i getting error msg or not

    Examples: 
      | userName | Password |
      | admin    | admin    |
      | admin    | adasdasd |
      | sdsdss   | admin    |
      | sdasdsd  | dsadsdsd |
