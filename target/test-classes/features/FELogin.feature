@FrondEnd
Feature: FE001 - Verify Login functionality

#-------------------------------------------------------------------------------
  @Priority=1 @ValidLogin
  Scenario: Verify that user could login with valid user name and pass
    Given Login Url
    And   Give user name "user@phptravels.com" and pass "demouser"
    And   Click Login button
    Then  Login successfully
