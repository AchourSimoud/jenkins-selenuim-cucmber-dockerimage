package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    @FindBy(className = "summary_subtotal_label")
    private WebElement htElement;

    @FindBy(className = "summary_tax_label")
    private WebElement taxeElement;

    @FindBy(className = "summary_total_label")
    private WebElement ttcElement;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> prixUnitaireElements;

    @FindBy(id = "finish")
    private WebElement finishElement;


    public CheckoutOverviewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getHtTotal(){
        return htElement;
    }

    public WebElement getTaxe(){
        return taxeElement;
    }

    public WebElement getTTC(){
        return ttcElement;
    }

    public List<WebElement> getPrixUnitaire(){
        return prixUnitaireElements;
    }

    public void clickFinish(){
        finishElement.click();
    }
}
