@BackEnd
Feature: BackEnd - Login

#-------------------------------------------------------------------------------
  @Priority=1 @ValidLogin
  Scenario: BE001 - Verify Login functionality
    Given Login BackEnd Url
    And   Provide user name "admin@phptravels.com" and pass "demoadmin"
    And   Click BackEnd Login button
    Then  BackEnd Login successfully
