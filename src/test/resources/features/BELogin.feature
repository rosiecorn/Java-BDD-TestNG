@BackEnd
Feature: BE001 - Verify Login functionality

#-------------------------------------------------------------------------------
  @Priority=1 @ValidLogin
  Scenario: Verify that user could login with valid user name and pass
    Given Login BackEnd Url
    And   Provide user name "admin@phptravels.com" and pass "demoadmin"
    And   Click BackEnd Login button
    Then  BackEnd Login successfully
