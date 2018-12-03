package pages;

import assertion.Asserts;
import bases.BasePage;
import drivers.Driver;
import elements.controllerImpl.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static utilities.BrowserUtils.scrollDown;


public class BELogin extends BasePage{


    private String url = "https://www.phptravels.net/admin";

    private final By txtUername =By.name("email");
    private final By txtPassword =By.name("password");
    private final By btnLogin =By.xpath("//*[@class='btn btn-primary btn-block ladda-button fadeIn animated']");
    private final By lblUserInformation = By.xpath("//*[@class='user']/span");
    private final By lstRecentBooking = By.xpath("//div[@class='xcrud']//td/div[contains(@class,'icheckbox_square-grey')]");
    private final By lstRecentBookingTble = By.xpath("//div[@class='xcrud-ajax']//table[contains(@class,'xcrud-list table table-striped table-hover')]");

    public void enterUserName(String userName) {
        getElement(TextBox.class,txtUername).clearAndSetText(userName);
    }

    public void enterPassWord(String pass)  {
        getElement(TextBox.class,txtPassword).clearAndSetText(pass);
    }

    public void click() {
        getElement(Button.class,btnLogin).clickAndWait();
    }

    public void selectAllBooking ()
    {

        List<WebElement> elements =  getListElement(lstRecentBooking);

        for (WebElement element :  elements)
        {
            getElement(RadioButton.class,element).clickAndWait();
        }
    }

    public void selectAllBooking_table ()
    {
        scrollDown(driver);

        List<WebElement> elements = getElement(Table.class,lstRecentBookingTble).getAllTableRowElement();

        for (WebElement element :  elements)
        {
            getElement(RadioButton.class,element).select();
        }

    }


    public  String getUserInfomation ()
    {
        return getElement(Element.class,lblUserInformation).getText();
    }

    public void openPage() {
        openPage(url);
    }
}
