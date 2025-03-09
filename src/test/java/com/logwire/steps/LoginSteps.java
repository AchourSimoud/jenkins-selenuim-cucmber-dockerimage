package com.logwire.steps;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.logwire.pages.InventoryPage;
import com.logwire.pages.LoginPage;
import com.logwire.tools.WebDriverTool;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage invetoryPage;

    public LoginSteps(){
        this.driver = WebDriverTool.getDriver();
        this.loginPage = new LoginPage(this.driver);
        this.invetoryPage = new InventoryPage(this.driver);
    }

    @Given("je suis sur la page {string}")
    public void je_suis_sur_la_page(String s) {
       WebDriverTool.getDriver().get(s);
    }

    @When("je saisi le username {string}")
        public void je_saisi_le_username(String s) {
            this.loginPage.saisirUsername(s);
        }

    @When("je saisi le password {string}")
    public void je_saisi_le_password(String s) {
        this.loginPage.saisirPassword(s);
    }    

    @When("je clique sur login")
    public void je_clique_sur_login() {
        this.loginPage.clickLogin();
    }

    @Then("je suis rederiger a la page produits")
    public void je_suis_rederiger_a_la_page_produits() {
        assertTrue(this.invetoryPage.getNbrProduits()>0);
    }

    @Then("je recoit un message erreur")
    public void je_re_oit_un_message_erreur() {
        assertTrue(this.loginPage.getError().isDisplayed());
    }

    

}

  