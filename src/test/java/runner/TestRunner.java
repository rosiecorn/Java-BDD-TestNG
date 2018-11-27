package runner;

import assertion.TestMethodListener;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features"}
        ,glue = {"stepDefs", "runner"}
        ,format = {"json:target/cucumber.json","html:/target/site/cucumber-pretty"}
        , plugin = {"pretty:target/cucumber-reports/cucumber.txt"
        ,"html:target/cucumber-reports"}
        , tags = {"@FrondEnd"}
)

@Listeners(TestMethodListener.class)
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;
    private Logger log = LogManager.getLogger(TestRunner.class);

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        bases.BaseTest.initalDriver();
        log.info(" ================================Start Cucumber Suite Class=====================================================");
    }

    @Before
    public void initializeTest(Scenario scenario){
        // System.out.println("This will run before each scenario");
        log.info("------Start Scenario: " + scenario.getName() + " ---------------------");
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        //  System.out.println("This will run before each scenario");
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        log.info("------End Scenario: " + scenario.getName() + " -----------------------");
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        bases.BaseTest.closeDriver();
        log.info("=================================End Cucumber Suite Class========================================================");
    }
}
