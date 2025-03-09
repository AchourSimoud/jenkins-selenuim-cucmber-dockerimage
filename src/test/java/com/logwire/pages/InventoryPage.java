package com.logwire.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    @FindBy(className = "btn_inventory")
    private List<WebElement> addBoutonsElements;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productsNamesElements;

    @FindBy(className = "shopping_cart_link")
    private WebElement panierElement;
    
    @FindBy(css = ".pricebar .btn_secondary")
    private List<WebElement> removeBoutonsElements;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> prixElements;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuElement;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutElement;

    @FindBy(css = ".right_component .select_container .product_sort_container")
    private WebElement filtreSelectionElement;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetElement;

    @FindBy(className = "shopping_cart_badge")
    private WebElement badgeElement;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //actions
    public int getNbrProduits(){
        return productsNamesElements.size();
    }

    // afficher le panier
    public void clickPanier(){
        panierElement.click();
    }

    public void addProduct(){
        for (WebElement addBouton : addBoutonsElements) {
            addBouton.click();
        }
    }

    public void removeProduct(){
        for (WebElement removeBouton : removeBoutonsElements) {
            removeBouton.click();
        }
    }

    public List<String> getAddedProduct(){
        List<String> nomsProduits = new ArrayList<>();
        for (WebElement bouton : removeBoutonsElements) {
            nomsProduits.add((bouton.getDomAttribute("id").replace("remove", "")).replace("-", " ").trim());            
        }
        return nomsProduits;
    }
   

    public void ordreProduits(String filtre){
        Select filtreProduits = new Select(filtreSelectionElement);
        filtreProduits.selectByVisibleText(filtre);
    }

    public List<Float> getPrixList(){
        List<Float> prixList = new ArrayList<>();
        for (WebElement p : prixElements) {
            prixList.add(Float.valueOf(p.getText().replaceAll("\\$", "")));
        }
        return prixList;
   }

   public List<String> getNomList(){
        List<String> nomList = new ArrayList<>();
        for (WebElement p : productsNamesElements) {
            nomList.add(p.getText());
        }
        return nomList;
    } 

    public int getBadgeNumber(){
        try {
            return Integer.valueOf(badgeElement.getText());
        } catch (Exception e) {
            return 0;
        }
        
    }

    public List<WebElement> getRemoveBoutons(){
        return removeBoutonsElements;
    }

    public void clickmenu(){
        menuElement.click();
    }

    public void logout(){
        logoutElement.click();
    }

    public void reset(){
        resetElement.click();
    }

}
