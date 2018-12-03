package stepDefs;

import assertion.Asserts;
import assertion.TestMethodListener;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import pages.FELogin;

import java.util.List;


public class FELoginStep {

    FELogin login = null;

    public FELoginStep() {
        login = new FELogin();
    }
    private Logger log = LogManager.getLogger(FELoginStep.class);


    @Given("^User on the Front-End Login Page$")
    public void userOnTheFrontEndLoginPage() {
        login.openPage();
        login.verifLoginPage();
    }

    @When("^User log in$")
    public void userLogIn(DataTable userData) {

        List<List<String>> data = userData.cells();
        login.enterUserName(data.get(0).get(0));
        login.enterPassWord(data.get(0).get(1));
        login.clickToMainPage();
    }

    @Then("^User should see main page display$")
    public void userShouldSeeMainPageDisplay(){
        login.verifyMainPage();
    }

//    @Then("^ddddd$")
//    public void ddddd() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
