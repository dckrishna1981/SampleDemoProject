package RA;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APITests {

    @Test
    public void getRequest()
    {
        given()
                .when().get("https://jsonplaceholder.typicode.com/posts/1")
                .then().statusCode(200).log().body();


    }

    @Test
    public void postRequest() {

        //using raw body
        //String jsonBody = "{ \"name\":\"Krishna\", \"salary\":\"123\", \"age\":\"23\" }";

        /*//using JsonObject
        JsonObject jsonBody=new JsonObject();
        jsonBody.addProperty("name","dck");
        jsonBody.addProperty("salary","125");
        jsonBody.addProperty("age","43");*/

        /*//using Existing JSON
        File jsonBody = new File("D:/TestNGPractice/Payloads/create.json");
        System.out.println(jsonBody.exists());*/

        //using hashmap
        Map jsonBody = new HashMap();
        jsonBody.put("name","maha");
        jsonBody.put("salary","100000");
        jsonBody.put("age","7");


        Response r =  given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("https://dummy.restapiexample.com/api/v1/create");

        String rBody = r.getBody().asString();
        System.out.println(jsonBody);
        String s =  r.jsonPath().getString("data.salary");
        int id=r.jsonPath().getInt("data.id");
        System.out.println("body  is " + rBody);
        System.out.println("Created ID " + id);


    }

    @Test
    public void pathQueryParams()
    {
        RestAssured.baseURI =  "https://jsonplaceholder.typicode.com";
        Response r = given().pathParam("posts",5).queryParam("id",42)
                .when()
                .get("{posts}");

        String s = r.getBody().asString();
        System.out.println(s);
        System.out.println(r.getStatusCode());




    }

}
