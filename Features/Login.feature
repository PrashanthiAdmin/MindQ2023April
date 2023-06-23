#Author: prashanthi.skvl@gmail.com


Feature: This feature is about login scenarios

  @validlogin @smoketest
  Scenario: User should login with valid credentials
    #Given I am in login page
    When I enter email id "prashanthi.skvl@gmail.com"
    And I enter password "Test@123"
    And I click sign in button
    Then I should be able to see the All projects page
    
    @invalidlogin @smoketest
    Scenario: User should not login with invalid credentials
    #Given I am in login page
    When I enter email id "test3245@gmail.com"
    And I enter password "test345"
    And I click sign in button
    Then I should see error message on the screen
    
    
    @invaliddatatest
    Scenario Outline: User should not login with different invalid data
    
     #Given I am in login page
     When I enter email id "<Emailid>"
    And I enter password "<Password>"
    And I click sign in button
    Then I should see error message on the screen
    
    Examples:
    |Emailid|Password|
    |test2345@gmail.com|test3456|
    |test456@gmail.com|Test@test1|
    
    
    

 
