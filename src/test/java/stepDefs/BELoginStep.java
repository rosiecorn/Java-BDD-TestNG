package stepDefs;

import assertion.Asserts;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import pages.BELogin;
import pages.FELogin;

public class BELoginStep {

    BELogin login = null;

    public BELoginStep() {
        login = new BELogin();
    }

    private Logger log = LogManager.getLogger(BELoginStep.class);



    @Given("^Login BackEnd Url$")
    public void loginBackEndUrl() {
       login.openPage();

    }

    @And("^Provide user name \"([^\"]*)\" and pass \"([^\"]*)\"$")
    public void provide_user_name_and_pass(String username, String password){
        login.enterUserName(username);
        login.enterPassWord(password);
    }

    @And("^Click BackEnd Login button$")
    public void click_BackEnd_Login_button(){
       login.click();

    }

    @Then("^BackEnd Login successfully$")
    public void backend_Login_successfully(){
      Asserts.verifyEquals(login.getUserInfomation(),"Super Admin","Actual is "+ login.getUserInfomation());
      login.selectAllBooking();
    }

}
