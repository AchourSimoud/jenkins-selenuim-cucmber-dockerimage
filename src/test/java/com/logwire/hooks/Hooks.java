package com.logwire.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.logwire.tools.WebDriverTool;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeEachSenario(){
        WebDriverTool.setUpDriver();
    }

    @After
    public void afterEachSenario(Scenario scenario){
    if (scenario.isFailed()) {
                try {
                    WebDriver driver = WebDriverTool.getDriver();
                    if (driver != null) {
                        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshot, "image/png", "Capture d'écran");
                    }
                } catch (Exception e) {
                    System.err.println("Erreur lors de la capture d'écran: " + e.getMessage());
                }
            }
            WebDriverTool.tearDown();;
        }   


}
