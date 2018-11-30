package pages;
import bases.BasePage;
import elements.controllerImpl.Button;
import elements.controllerImpl.Element;
import elements.controllerImpl.TextBox;
import org.openqa.selenium.WebElement;
import  org.openqa.selenium.By;

public class FELogin extends BasePage{

    private final By txt_uername =By.name("username");
    private final By txt_password =By.name("password");
    private final By btn_Login =By.xpath("//*[@id='loginfrm']/button");
    private String url = "https://www.phptravels.net/login";


    public void enterUserName(String userName) {
        getElement(TextBox.class,txt_uername).clearAndSetText(userName);
    }

    public void enterPassWord(String pass)  {
        getElement(TextBox.class,txt_password).clearAndSetText(pass);
    }

    public void clickToMainPage() {
        getElement(Button.class,btn_Login).clickAndWait();
    }


    public void openPage() {
        openPage(url);
    }
}
