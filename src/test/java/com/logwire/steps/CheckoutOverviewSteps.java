package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.logwire.pages.CheckoutOverviewPage;
import com.logwire.tools.WebDriverTool;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

   
public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage;
    WebDriver driver;

    public CheckoutOverviewSteps(){
        this.driver = WebDriverTool.getDriver();
        this.checkoutOverviewPage = new CheckoutOverviewPage(this.driver);
    }
    @Then("le totale ttc affiche est egal a {string}")
    public void le_totale_ttc_affiche_est_egal_a(String s) {
        assertEquals(Float.valueOf(s), Float.valueOf(this.checkoutOverviewPage.getTTC().getText().replaceAll("[^0-9.]", "")));
    }
    
    @Then("le totale hors taxe affiche est egal a {string}")
    public void le_totale_hors_taxe_affiche_est_egal_a(String s) {
        assertEquals(Float.valueOf(s), Float.valueOf(this.checkoutOverviewPage.getHtTotal().getText().replaceAll("[^0-9.]", "")));
    }

    @Then("je suis redirige vers la page de remerciement {string}")
    public void je_suis_redirige_vers_la_page_de_remerciement(String s) {
        assertEquals(s, this.driver.getCurrentUrl());
    }

    @When("je click sur le bouton finish")
    public void je_click_sur_le_bouton_finish() {
        this.checkoutOverviewPage.clickFinish();
    }

}
