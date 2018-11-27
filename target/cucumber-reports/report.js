$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "FE001 - Verify Login functionality",
  "description": "",
  "id": "fe001---verify-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FrondEnd"
    }
  ]
});
formatter.before({
  "duration": 621827,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 4,
      "value": "#-------------------------------------------------------------------------------"
    }
  ],
  "line": 6,
  "name": "Verify that user could login with valid user name and pass",
  "description": "",
  "id": "fe001---verify-login-functionality;verify-that-user-could-login-with-valid-user-name-and-pass",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Priority\u003d1"
    },
    {
      "line": 5,
      "name": "@ValidLogin"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Login Url",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Give user name \"user@phptravels.com\" and pass \"demouser\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click Login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.login_Url()"
});
formatter.result({
  "duration": 5829084772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user@phptravels.com",
      "offset": 16
    },
    {
      "val": "demouser",
      "offset": 47
    }
  ],
  "location": "LoginStep.give_user_name_and_pass(String,String)"
});
formatter.result({
  "duration": 429030490,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.click_Login_button()"
});
formatter.result({
  "duration": 3170557697,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.login_successfully()"
});
formatter.result({
  "duration": 62024,
  "status": "passed"
});
formatter.after({
  "duration": 928791,
  "status": "passed"
});
});