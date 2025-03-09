package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.logwire.pages.CartPage;
import com.logwire.pages.InventoryPage;
import com.logwire.pages.LoginPage;
import com.logwire.tools.WebDriverTool;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage invetoryPage;
    CartPage cartPage;

    public CartSteps(){
        this.driver = WebDriverTool.getDriver();
        this.loginPage = new LoginPage(driver);
        this.invetoryPage = new InventoryPage(driver);
        this.cartPage = new CartPage(driver);

    }

    @When("je click sur le bouton continue shopping")
    public void je_click_sur_le_bouton_continue_shopping() {
        this.cartPage.continueShopping();
    }

    @Then("je retrouve tous les produits dans le panier")
    public void je_retrouve_tous_les_produits_dans_le_panier() {
        List<String> produits = Arrays.asList(
            "sauce labs backpack",
            "sauce labs bike light",
            "sauce labs bolt t shirt",
            "sauce labs fleece jacket",
            "sauce labs onesie",
            "test.allthethings() t shirt (red)"
        );
        assertEquals(produits, this.cartPage.getAddedProduct());
    }

    @Then("je retrouve ces produits dans le panier")
    public void je_retrouve_ces_produits_dans_le_panier() {
        List<String> produits = Arrays.asList(
            "sauce labs backpack",
            "sauce labs bike light",
            "sauce labs bolt t shirt",
            "sauce labs fleece jacket",
            "sauce labs onesie",
            "test.allthethings() t shirt (red)"
        );
        assertEquals(produits, this.invetoryPage.getAddedProduct());
    }

    @When("je click sur le bouton checkout")
    public void je_click_sur_le_bouton_checkout() {
        this.cartPage.checkout();
    }

    @Then("je suis redirige vers la page {string}")
    public void je_suis_redirige_vers_la_page(String s) {
        assertEquals(s, this.driver.getCurrentUrl());
    }

    @Then("je ne suis pas redirige vers la page {string}")
    public void je_ne_suis_pas_redirige_vers_la_page(String s) {
        assertEquals(s, this.driver.getCurrentUrl());
    }


}
