import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class rest
{
    public static void main(String[] args)
    {
        //baseURI = "https://reqres.in/api";
        /*
        Response r = RestAssured.given().get("/users/2");
        System.out.println(r.getStatusCode());
        //System.out.println(r.getBody().asPrettyString());
        JsonPath json=r.jsonPath();
        System.out.println(json.getInt("data.id"));
        System.out.println(json.getString("support.url"));
        System.out.println(json.getString("support.text"));


        JsonObject jo=new JsonObject();
        jo.addProperty("name","krishna");
        jo.addProperty("job","nojob");
        String rbody=jo.toString();*/

        Response r = RestAssured.given().when().get("https://reqres.in/api/users/2");

      r.then().body("data.id",equalTo(2));




    }
}
