package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(className = "checkout_info")
    private WebElement checkoutInfoElement;

    @FindBy(id = "first-name")
    private WebElement firstNameElement;

    @FindBy(id = "last-name")
    private WebElement lastNameElement;

    @FindBy(id = "postal-code")
    private WebElement zipCodeElement;

    @FindBy(id = "continue")
    private WebElement continuBoutonElement;

    @FindBy(css = ".error-message-container")
    private WebElement errorElement;


    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void saisirFirstName(String firstName){
        firstNameElement.sendKeys(firstName);
    }

    public void saisirLastName(String lastName){
        lastNameElement.sendKeys(lastName);
    }

    public void saisirZipCode(String zipCode){
        zipCodeElement.sendKeys(zipCode);
    }

    public WebElement getChekoutInfo(){
        return checkoutInfoElement;
    }

    public void continueClick(){
        continuBoutonElement.click();
    }

    public WebElement getErrorElement(){
        return errorElement;
    }
}
