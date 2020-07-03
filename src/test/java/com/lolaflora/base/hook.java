package com.lolaflora.base;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ResourceBundle;


public class hook {
    public static WebDriver driver;
    protected static ResourceBundle elementAdreses;

    @BeforeScenario
    public void setUp(){
        String baseUrl = "https://www.lolaflora.com/";
        elementAdreses=ReadProperties.readProp("elements.properties");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterScenario
    public void afterSenario()
    {
        driver.quit();
    }

}
