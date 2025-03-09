package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.openqa.selenium.WebDriver;

import com.logwire.pages.CartPage;
import com.logwire.pages.CheckoutPage;
import com.logwire.pages.InventoryPage;
import com.logwire.pages.LoginPage;
import com.logwire.tools.WebDriverTool;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public CheckoutSteps(){
        this.driver = WebDriverTool.getDriver();
        this.loginPage = new LoginPage(this.driver);
        this.inventoryPage = new InventoryPage(this.driver);
        this.cartPage = new CartPage(this.driver);
        this.checkoutPage = new CheckoutPage(this.driver);  
    }

    @When("je saisi le first name {string}")
    public void je_saisi_le_first_name(String s) {
        this.checkoutPage.saisirFirstName(s);
    }

    @When("je click sur le bouton continue")
    public void je_click_sur_le_bouton_continue() {
        this.checkoutPage.continueClick();
    }

    @When("je saisi le code postal {string}")
    public void je_saisi_le_code_postal(String s) {
        this.checkoutPage.saisirZipCode(s);
    }

    @When("je saisi le last name {string}")
    public void je_saisi_le_last_name(String s) {
        this.checkoutPage.saisirLastName(s);    
    }

    @Then("je suis redirige sur la page {string}")
    public void je_suis_redirige_sur_la_page(String s) {
        assertEquals(s, this.driver.getCurrentUrl());
    }

    @Then("je ne suis pas redirige sur la page {string}")
    public void je_ne_suis_pas_redirige_sur_la_page(String s) {
        assertNotEquals(s, this.driver.getCurrentUrl());
    }
    @Then("je ne suis pas redirige sur la page1 {string}")
    public void je_ne_suis_pas_redirige_sur_la_page1(String s) {
        assertEquals(s, this.driver.getCurrentUrl());
    }

    
}
