package Base;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;


public class RestAssuredDemo
{
   // @Test
    public void m1()
    {
        given()
                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200);
                //.body("data.email",equalTo("janet.weaver@reqres.in"))
                //.log().body();
    }

   // @Test
    public void m2()
    {
        int id;
        id=given()
                .when()
                .get("https://reqres.in/api/users/2")
                .jsonPath().getInt("data.id");
        System.out.println("id ->"+id);


    }

    @Test
    public void m3()
    {
        Response res ;
        res=given()
                .when()
                .get("https://reqres.in/api/users/2");

        System.out.println("email ->"+res.jsonPath().getString("data.email"));
        System.out.println("status code ->"+res.getStatusCode());
        System.out.println("body ->"+res.getBody().toString());


    }
}
