package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class WebDriverTool {

    static public WebDriver driver;

    static public void setUpDriver(){
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "chrome":
                try {
                    // Créer un répertoire temporaire unique pour chaque session de Chrome
                    // Vous pouvez enlever cette partie si vous ne souhaitez pas utiliser --user-data-dir
                    Path tempDir = Files.createTempDirectory("chrome-user-data-dir");
                    
                    // Options de Chrome
                    ChromeOptions options = new ChromeOptions();
                    // Si vous ne voulez pas utiliser le --user-data-dir, vous pouvez le commenter
                    options.addArguments("--user-data-dir=" + tempDir.toAbsolutePath().toString());
                    options.addArguments("--headless");  // Facultatif : exécuter Chrome sans interface graphique
                    options.addArguments("--disable-gpu"); // Facultatif : utile dans les environnements sans GPU
                    options.addArguments("--no-sandbox");  // Facultatif : souvent nécessaire dans les conteneurs Docker

                    // Utiliser Chrome avec ces options
                    driver = new ChromeDriver(options);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
                
            default:
                // Par défaut, utiliser Chrome sans options si le navigateur spécifié n'est pas supporté
                driver = new ChromeDriver();
                break;
        }

        // Maximiser la fenêtre du navigateur
        driver.manage().window().maximize();
    }

    static public WebDriver getDriver(){
        return driver;
    }

    static public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
