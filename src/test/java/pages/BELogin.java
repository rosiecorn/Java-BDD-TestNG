package pages;

import assertion.Asserts;
import bases.BasePage;
import drivers.Driver;
import elements.controllerImpl.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;



public class BELogin extends BasePage{


    private String url = "https://www.phptravels.net/admin";

    private final By txtUername =By.name("email");
    private final By txtPassword =By.name("password");
    private final By btnLogin =By.xpath("//*[@class='btn btn-primary btn-block ladda-button fadeIn animated']");
    private final By lblUserInformation = By.xpath("//*[@class='user']/span");
   // private final By lstRecentBooking = By.xpath("//div[@class='xcrud']//td/div[contains(@class,'icheckbox_square-grey')]");
    //private final By lstRecentBookingTble = By.xpath("//div[@class='xcrud-ajax']//table[contains(@class,'xcrud-list table table-striped table-hover')]");
    private final By mainMenu = By.xpath("//div[contains(@class,'row form-group')]//button");
    private final By lblPanelHeading = By.xpath("//div[contains(@class,'panel-heading')]");
    private final By lblErrorMessage = By.xpath("//div[contains(@class,'alert ')]");
    private final By btnLogOut = By.xpath("//*[text()='Log Out']/parent::div");


    public void enterUserName(String userName) {
        getElement(TextBox.class,txtUername).clearAndSetText(userName);
    }

    public void enterPassWord(String pass)  {
        getElement(TextBox.class,txtPassword).clearAndSetText(pass);
    }

    public void click() {
        getElement(Button.class,btnLogin).clickAndWait();
    }

    public void logOut ()
    {
        getElement(Element.class,btnLogOut).click();
    }

    public void verifyMenu()
    {
       List<WebElement> elements = getListElement(mainMenu);

       for(WebElement element:elements)
       {
           String text = element.getText();
           String actualBackground = element.getCssValue("background-color");

           log.info(" Correct Back Ground color of " + element.getText() + " button is " + element.getCssValue("background-color"));

          if (text=="QUICK BOOKING")
            Asserts.verifyEquals(actualBackground,"rgba(238, 95, 91, 1)");

          if (text=="BOOKING")
            Asserts.verifyEquals(actualBackground,"rgba(70, 109, 241, 1)");

          if (text=="CMS PAGES")
               Asserts.verifyEquals(actualBackground,"rgba(91, 192, 222, 1)");

          if (text=="BLOG")
               Asserts.verifyEquals(actualBackground,"rgba(98, 196, 98, 1)");

          if (text=="SEND NEWSLETTER")
               Asserts.verifyEquals(actualBackground,"rgba(251, 180, 80, 1)");

          if (text=="BACKUP DATABSE")
               Asserts.verifyEquals(actualBackground,"rgba(255, 255, 255, 1)");
       }

       Asserts.verifyAll();


    }

    public void verifyPanelHeading()
    {
        List<WebElement> elements = getListElement(lblPanelHeading);

        List<String> expectedPanelHeading = new ArrayList<>(5);
        List<String> actualPanelHeading = new ArrayList<>();

        expectedPanelHeading.add("BOOKING SUMMARY");
        expectedPanelHeading.add("REVENUE CHART");
        expectedPanelHeading.add("RECENT BOOKINGS");
        expectedPanelHeading.add("VISIT STATISTICS OF JANUARY\n" +
                "RESET CHART");

        for(WebElement element : elements)
        {
            actualPanelHeading.add(element.getText());
        }

        Asserts.verifyEquals(actualPanelHeading,expectedPanelHeading);
        Asserts.verifyAll();
    }

    public  String getUserInfomation ()
    {
        return getElement(Element.class,lblUserInformation).getText();
    }

    public void openPage() {
        openPage(url);
    }

    public void verifyErrorMessage ( String message)
    {
        Asserts.verifyEquals(getElement(Element.class,lblErrorMessage).getText(),message);
        Asserts.verifyAll();
    }

}
