package bases;

import drivers.Driver;
import elements.controller.*;
import org.openqa.selenium.By;
import utilities.BrowserUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.reflect.Constructor;
import java.util.List;

import static utilities.Contants.SECOND_TIME_OUT;

public class BasePage {

    public static WebDriver driver = null;

    private IElement element;

    private ITextBox textBox;

    private IRadioButton radio;

    private IButton button;

    private ITable table;

    private List<WebElement> elements;

    WebDriverWait wait;


    public BasePage() {

        if (this.driver==null)
        {
            this.driver = Driver.getInstance().getDriver();
        }
        wait = new WebDriverWait(driver, SECOND_TIME_OUT);
    }


    public  <T> T getElement(Class<T> type, By locators) {
        try {

            Constructor<T> constructor = type.getDeclaredConstructor(WebElement.class);

            return constructor.newInstance(wait.until(ExpectedConditions.visibilityOf(driver.findElement(locators))));


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * getTitle - method to return the title of the current page
     *
     * @throws Exception
     */

    public String getTitle() throws Exception {
        // WebDriver driver = Driver.getInstance().getDriver();

        return driver.getTitle();
    }


    /**
     * loadPage - overloaded method to load the page URL and sync  *
     * * @param pageURL
     * * @param landingUrl
     * * @throws Exception
     */
    public void openPage(String pageURL) {

        driver.manage().window().maximize();
        driver.navigate().to(pageURL);

        // wait for page download, sync.
        BrowserUtils.isPageReady(driver);

       // BrowserUtils.waitForURL(pageURL,TIMEOUT_SECOND);

    }


}
