package com.lolaflora;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import com.lolaflora.base.hook;
import com.thoughtworks.gauge.Step;
import com.lolaflora.base.methods;
import groovy.json.JsonException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.parser.Parser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Step("Tüm kadınlar cicektir.")
    public void cicekSepetiAlAl() {

        Response r =
                given()
                        .when()
                        .get("https://www.getpostman.com/collections/5d9f72679607a60f23af");
        String Code = r.jsonPath().getString("item.response.code[0]");
        assertEquals("[200]",Code);
        System.out.println(r.jsonPath().getString("item.response.body.result"));
    }
    @Step("Api Testini Gerçekleştir")
    public void api() {
        API.apiTest();
    }


}
