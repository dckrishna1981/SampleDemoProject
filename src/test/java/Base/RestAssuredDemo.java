package Base;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;


public class RestAssuredDemo
{
    //@Test
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

    @Test
    public void m2() throws InterruptedException {
        int id;
        id=given()
                .when()
                .get("https://reqres.in/api/users/2")
                .jsonPath().getInt("data.id");
        System.out.println("id ->"+id);
        //Thread.sleep(100000);


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
        System.out.println("chinnikrishna");
        Assert.assertEquals(500,500);
        Assert.assertEquals(6,6);
        Assert.assertEquals(7,7);

    }
}
