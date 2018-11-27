package stepDefs;

import assertion.Asserts;
import assertion.TestMethodListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.java.StepDefAnnotation;
import gherkin.formatter.model.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Login;
import runner.TestRunner;

public class LoginStep {

    //Logger  log = LogManager.getLogger(LoginStep.class);
    Login login = null;

    public LoginStep() {
        login = new Login();
    }
    private Logger log = LogManager.getLogger(LoginStep.class);

    @Given("^Login Url$")
    public void login_Url()  {

      // Asserts.verifyEquals(1,2,"not equal testing");
      // Asserts.verifyEquals(1,3,"equal testing");
        login.openPage();
      Asserts.verifyEquals(1,2,"error");
        Asserts.verifyEquals(1,3,"error");
        Asserts.verifyEquals(1,1,"error");

    }


    @And("^Give user name \"([^\"]*)\" and pass \"([^\"]*)\"$")
    public void give_user_name_and_pass(String arg1, String arg2)  {
        System.out.println("Login with UserName " + arg1 + " and password " + arg2);
        login.enterUserName(arg1);
        login.enterPassWord(arg2);
    }

    @And("^Click Login button$")
    public void click_Login_button() throws Throwable {
        System.out.println("Click Button login");
        login.clickToMainPage();
    }

    @Then("^Login successfully$")
    public void login_successfully() throws Throwable {
        System.out.println("login_successfully");
    }


}
