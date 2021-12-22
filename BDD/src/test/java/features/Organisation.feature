Feature: user can create modify and delete organization

  Background: 
    Given i will launch browser
    And enter the url "http://localhost:8888"
    And Login page is displayed and i will enter username "admin" and password "admin"
    And click on login button

  #Scenario Outline: As a valid user create a multiple organization
    #When home page is displayed
    #And click on organisation
    #And click on create organization
    #And enter organisation name "<organization>" and click on save button
    #Then verify organization "<organization>" is created or not
#
    #Examples: 
      #| organization |
      #| Amazon       |


  Scenario: As a valid user create organization with organization, website, phone and employee
    When home page is displayed
    And click on organisation
    And click on create organization
    And Enter organisation name, phone, website and employees
      | organisation name | phone      | website       | employees |
      | TestYantra        | 9964648142 | www.sumne.com |      2000 |
    And click on save button
    Then verify organisation name, phone, website, employees is created or not
