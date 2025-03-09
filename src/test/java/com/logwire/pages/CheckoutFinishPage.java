package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage {
    @FindBy(css = ".complete-header")
    private WebElement completeMessageElement;

    @FindBy(id = "back-to-products")
    private WebElement backHomeElement;

    public CheckoutFinishPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void backHome(){
        backHomeElement.click();
    }

    public WebElement getCompleteMessage(){
        return completeMessageElement;
    }
}
