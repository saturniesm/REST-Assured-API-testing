package reqres;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class put_user_test {

    Map<String, Object> user = new HashMap<String, Object>();

    @Test
    public void put_user(){
        //convert java obj to json
        JSONObject req = new JSONObject(user);
        req.put("email", "ikan");
        req.put("job", "office");


        given()
            .header("Content-Type", "application/json")
            .accept(ContentType.JSON)
            .body(req.toJSONString())
        .when()
            .put("https://reqres.in/api/users/2")
        .then()
            .statusCode(200)
            .log().all();
    }
}
