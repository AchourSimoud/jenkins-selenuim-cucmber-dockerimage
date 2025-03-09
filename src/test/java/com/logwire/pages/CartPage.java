package com.logwire.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(css = ".inventory_item_price .cart_button")
    private List<WebElement> removeBoutonsElements;

    @FindBy(id = "checkout")
    private WebElement checkoutBoutonElement;

    @FindBy(css = ".cart_item .cart_item_label .inventory_item_name")
    private List<WebElement> productsNamesElements;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingElement;


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
    public void removeCartProducts(){
        for (WebElement removeBouton : removeBoutonsElements) {
            removeBouton.click();
        }
    }

    public List<String> getAddedProduct(){
        List<String> addedProductsNames = new ArrayList<>();
        for (WebElement productName : productsNamesElements) {
            addedProductsNames.add(productName.getText().toLowerCase().replace("-", " "));
        }
        return addedProductsNames;
    }

    public void continueShopping(){
        continueShoppingElement.click();
    }

    public void checkout(){
        checkoutBoutonElement.click();
    }


}
