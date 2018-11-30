$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BELogin.feature");
formatter.feature({
  "line": 2,
  "name": "BE001 - Verify Login functionality",
  "description": "",
  "id": "be001---verify-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@BackEnd"
    }
  ]
});
formatter.before({
  "duration": 449185,
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
  "id": "be001---verify-login-functionality;verify-that-user-could-login-with-valid-user-name-and-pass",
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
  "name": "Login BackEnd Url",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Provide user name \"admin@phptravels.com\" and pass \"demoadmin\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click BackEnd Login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "BackEnd Login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "BELoginStep.loginBackEndUrl()"
});
formatter.result({
  "duration": 5424729847,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@phptravels.com",
      "offset": 19
    },
    {
      "val": "demoadmin",
      "offset": 51
    }
  ],
  "location": "BELoginStep.provide_user_name_and_pass(String,String)"
});
formatter.result({
  "duration": 898444997,
  "status": "passed"
});
formatter.match({
  "location": "BELoginStep.click_BackEnd_Login_button()"
});
formatter.result({
  "duration": 3127085877,
  "status": "passed"
});
formatter.match({
  "location": "BELoginStep.backend_Login_successfully()"
});
formatter.result({
  "duration": 33020004354,
  "status": "passed"
});
formatter.after({
  "duration": 1239704,
  "status": "passed"
});
});