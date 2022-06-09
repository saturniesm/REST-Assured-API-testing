package reqres;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class post_user_test {
    //storing array in key value pairs
    // this map has key as a string and value as an object
    Map<String, Object> user = new HashMap<String, Object>();


    @Test
    public void post_user(){
        //convert java obj to json
        JSONObject req = new JSONObject(user);
        req.put("name", "ikan");
        req.put("job", "office");

        given()
            .header("Content-Type", "application/json")
            .accept(ContentType.JSON)
            .body(req.toJSONString())
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }


}
