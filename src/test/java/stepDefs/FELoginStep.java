package stepDefs;

import assertion.Asserts;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.FELogin;

public class FELoginStep {

    //Logger  log = LogManager.getLogger(FELoginStep.class);
    FELogin login = null;

    public FELoginStep() {
        login = new FELogin();
    }
    private Logger log = LogManager.getLogger(FELoginStep.class);

    @Given("^Login Url$")
    public void login_Url()  {

        login.openPage();

    }


    @And("^Give user name \"([^\"]*)\" and pass \"([^\"]*)\"$")
    public void give_user_name_and_pass(String arg1, String arg2)  {
        System.out.println("FELogin with UserName " + arg1 + " and password " + arg2);
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
