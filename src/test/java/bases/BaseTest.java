package bases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.Driver;
import org.openqa.selenium.WebDriver;

public class BaseTest {


   private static  String browser = System.getProperty("browser");//Get browser value from cmd


    public static void initalDriver () {

        System.out.println("Starting web driver");
        Driver.getInstance().setDriver("chrome");
    }
    public static void closeDriver () {
        System.out.println("Closing web driver");
        Driver.getInstance().closeDriver();

    }

}



