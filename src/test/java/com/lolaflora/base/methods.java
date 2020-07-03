package com.lolaflora.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class methods {

    WebDriver driver=hook.driver;
    ResourceBundle elementAdreses=ReadProperties.readProp("elements.properties");
    WebDriverWait wait = new WebDriverWait(driver,10);


    public WebElement findElementByKey(String key){
        WebElement element=null;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getElemtntAdressByKey(key))));
            element=driver.findElement(By.xpath(getElemtntAdressByKey(key)));
        }catch (Exception e){
            Assert.fail(key+" Elementi sayfada bulunamadı");
        }
        return element;
    }

    public String getElemtntAdressByKey(String key){
        return elementAdreses.getString(key);
    }

    public boolean doesElementExist(String key){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getElemtntAdressByKey(key))));
            driver.findElement(By.xpath(getElemtntAdressByKey(key)));
            return true;
        }catch (Exception e){
            System.out.println(key+" Elementi sayfada bulunamadı");
        }
        return false;
    }


}
