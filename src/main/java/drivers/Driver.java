package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // this is our driver that will be used for all selenium actions
    // local variables

    private static Driver instance = null;

    private static final int IMPLICIT_TIMEOUT = 0;

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();


    // constructor
    private Driver() {
    }

    /**
     * getInstance method to retrieve active driver instance
     *
     * @return CreateDriver
     */
    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }

        return instance;
    }

    /**
     * getDriver method will retrieve the active WebDriver
     *
     * @return WebDriver
     */

    public WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * getCurrentDriver method will retrieve the active WebDriver
     *
     * @return WebDriver
     */

    public WebDriver getCurrentDriver() {
        return getInstance().getDriver();

    }

    // a method for allowing selenium to pause for a set amount of time
    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public void setDriver(String browser) {
        switch (browser) { // check our browser
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                webDriver.set(new FirefoxDriver());
                break;
            }
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                webDriver.set(new ChromeDriver());
                break;
            }
            case "ie": {
                webDriver.set(new InternetExplorerDriver());
                break;
            }
            // if our browser is not listed, throw an error
            default: {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                webDriver.set(new ChromeDriver());
            }
        }
    }

    public void wait(double seconds) throws InterruptedException {
        Thread.sleep(Double.doubleToLongBits(seconds * 1000));
    }

    /**
     * driverWait method pauses the driver in seconds
     *
     * @param seconds to pause
     */

    public void driverWait(long seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));

        } catch (InterruptedException e) {
            // do something     //
        }
    }

    /**
     * driverRefresh method reloads the current browser page
     */
    public void driverRefresh() {
        getCurrentDriver().navigate().refresh();
    }

    /**
     * closeDriver method quits the current active driver
     */
    public void closeDriver() {
        try {
            getCurrentDriver().quit();
        } catch (Exception e) {         // do something    //
        }
    }
}
