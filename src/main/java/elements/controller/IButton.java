package elements.controller;

import org.openqa.selenium.WebDriver;

public interface IButton extends IElement {

    void mouseClick(WebDriver driver);

    void javascriptClick(WebDriver driver);

}