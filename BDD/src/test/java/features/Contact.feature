Feature: i create a contact in vTiger application

  Background: 
    Given i will launch browser
    And enter the url "http://localhost:8888"
    And Login page is displayed and i will enter username "admin" and password "admin"
    And click on login button

  Scenario: i will login to vtiger using valid credentials and i create contact by entering frirstName, LastName, phoneNumber and emailId
    Then Click on Contact module
    And Click on create contact
    And enter frirstName, LastName, phoneNumber and emailId
      | frirstName | LastName | phoneNumber | emailId              |
      | vinay      | suresh   |  9964648142 | vinayms168@gmail.com |
    And click on save button in contact module
    Then Verify frirstName, LastName, phoneNumber and emailId created or not
