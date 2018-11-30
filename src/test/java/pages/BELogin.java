package pages;

import bases.BasePage;
import elements.controllerImpl.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static utilities.BrowserUtils.*;


public class BELogin extends BasePage{


    private String url = "https://www.phptravels.net/admin";

    private final By txt_uername =By.name("email");
    private final By txt_password =By.name("password");
    private final By btn_Login =By.xpath("//*[@class='btn btn-primary btn-block ladda-button fadeIn animated']");
    private final By lbl_userInfo = By.xpath("//*[@class='user']/span[text()='Super Admin']");
    private final By lbl_userInformation = By.xpath("//*[@class='user']/span");
    private final By list_recentBooking = By.xpath("//div[@class='xcrud']//td/div[contains(@class,'icheckbox_square-grey')]");
    private final By list_recentBooking_table = By.xpath("//div[@class='xcrud-ajax']//table[contains(@class,'xcrud-list table table-striped table-hover')]");




    public void enterUserName(String userName) {
        getElement(TextBox.class,txt_uername).clearAndSetText(userName);
    }

    public void enterPassWord(String pass)  {
        getElement(TextBox.class,txt_password).clearAndSetText(pass);
    }

    public void click() {
        getElement(Button.class,btn_Login).clickAndWait();
    }

    public void selectAllBooking ()
    {
        scrollDown(driver);

        List<WebElement> elements =  getListElement(list_recentBooking);

        for (WebElement element :  elements)
        {
            getElement(RadioButton.class,element).select();
        }

       sleep(3000);

    }

    public void selectAllBooking_table ()
    {
        scrollDown(driver);

        List<WebElement> elements = getElement(Table.class,list_recentBooking_table).getAllTableRowElement();

        for (WebElement element :  elements)
        {
            getElement(RadioButton.class,element).select();
        }

    }


    public  String getUserInfomation ()
    {
        return getElement(Element.class,lbl_userInformation).getText();
    }
    public void openPage() {
        openPage(url);
    }
}
