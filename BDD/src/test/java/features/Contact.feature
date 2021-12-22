Feature: i create a contact in vTiger application

  Background: 
    Given i will launch browser
    And enter the url "http://localhost:8888"
    And Login page is displayed and i will enter username "admin" and password "admin"
    And click on login button
    And click on organisation
    And click on create organization
    And Enter organisation name, phone, website and employees
      | organisation name | phone      | website       | employees |
      | TestYantra        | 9964648142 | www.sumne.com |      2000 |
    And click on save button

  Scenario: i will login to vtiger using valid credentials and i create contact by entering frirstName, LastName, phoneNumber and emailId
    Then Click on Contact module
    And Click on create contact
    And enter frirstName, LastName, phoneNumber and emailId
      | frirstName | LastName | phoneNumber | emailId              |
      | vinay      | suresh   |  9964648142 | vinayms168@gmail.com |
    And click on Organization look up page
    And select Organization from lookUp Page
    And click on save button in contact module
    Then Verify frirstName, LastName, phoneNumber and emailId created or not 