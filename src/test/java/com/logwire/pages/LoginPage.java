package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "login-button")
    private WebElement submiElement;

    @FindBy(className = "error")
    private WebElement errorElement;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
    //actions
    public void saisirUsername(String username){
        usernameElement.sendKeys(username);
    }

    public void saisirPassword(String password){
        passwordElement.sendKeys(password);
    }

    public void clickLogin(){
        submiElement.click();
    }

    public WebElement getError(){
        return errorElement;
    }

    public WebElement getUsernameElement(){
        return usernameElement;
    }

    public void login(String username, String password){
        saisirUsername(username);
        saisirPassword(password);
        clickLogin();
    }
}
