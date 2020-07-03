package com.lolaflora;

import com.lolaflora.base.hook;
import com.thoughtworks.gauge.Step;
import com.lolaflora.base.methods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


//import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

//import io.restassured.response.Response;



public class StepImplementation extends methods {

    WebDriver driver= hook.driver;


    @Step("<key> elementine tıkla")
    public void clickElementWithKey(String key) {

        findElementByKey(key).click();
    }

    @Step("<key> elementi üzerinde dur")
    public void holdOverElementWithKey(String key) {
        Actions action = new Actions(driver);
        action.moveToElement(findElementByKey(key)).build().perform();
    }
    @Step("<key> elementine <text> degerini gir")
    public void holdOverElementWithKey(String key, String text) {
      findElementByKey(key).sendKeys(text);
    }
    @Step("<key> elementi sayfada yoksa <text> hata mesajını göster")
    public void elementAssertion(String key, String text){
        Assert.assertTrue(text,doesElementExist(key));

    }



}
