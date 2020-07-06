package com.lolaflora;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONException;
import com.github.openjson.JSONObject;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API {
    private static Response r= given().when().get("https://www.getpostman.com/collections/5d9f72679607a60f23af");
    public static void apiTest() {
        //baglantı kontrol
        String Code = r.jsonPath().getString("item.response.code[0]");
        assertEquals("[200]",Code);

        int i=0;
        while (true){
            try{
                String gsonText=r.jsonPath().getString("item.response.body["+i+"]");
                System.out.println(i+" numara body json alındı");
                i++;
                apiTest(gsonText);
            }catch (JSONException e){
                System.out.println(i+" numara body json bulunamadı");
                break;
            }
        }

    }
    public static void apiTest(String gsonText){
        Boolean installment=null;
        String installmentText=null;
        JSONObject jsonObject = new JSONObject(gsonText.substring(1,gsonText.length()-1));
        JSONArray arr= new JSONArray(jsonObject.getJSONObject("result").getJSONObject("data").getJSONArray("products").toString());
        int i=0;
        while(true){
            try{
                installment =arr.getJSONObject(i).getBoolean("installment");
                installmentText=arr.getJSONObject(i).getString("installmentText");
                System.out.println("installment= "+installment+"  installmentText = "+installmentText);
            } catch (JSONException e){
        System.out.println(i+" numaralı installment bulunamadı birsonra ki body'e geçiliyor.");
        break;
            }

            Assert.assertNotNull("installment NULL dönmüştür 'status 500'",installment);
            Assert.assertEquals("installment = "+installment+
                    " iken "+"installmentText = '"+installmentText+
                    "' oldugu için koşum fail vermiştir.",
                    installment,installmentText.contains("Taksit"));
            i++;
        }

    }
}
