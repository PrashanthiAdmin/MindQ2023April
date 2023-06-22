#Author: prashanthi.skvl@gmail.com


Feature: This feature is about sign up scenarios Storyid:123

  @validsignup @smoketest
  Scenario: User should signup with email
   Given I am in signup page
   When I enter email id
   And I enter password
   And I click signup button
   Then I should be registered