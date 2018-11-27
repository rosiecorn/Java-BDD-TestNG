package elements.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

public interface IElement extends WebElement, WrapsElement, Locatable {

    void hover (WebDriver driver);
    void hoverAndClick(WebDriver driver);
    void clickAndWait();

}
