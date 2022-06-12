package reqres.datadriven;

// TODO save import in one file
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;


public class post_user_test {

    @DataProvider(name = "dataPost")
    public Object [][] data() {

        // -- hardcode array index --
        // Object [][] data = new Object [2][2];
        // data[0][0] = "ikan";
        // data[0][1] = "goreng";
        // return data;

        return new Object[][] {
            {"soto", "bakar"},
            {"ayam", "geprek"},
            {"ikan", "pepes"}
        };
    }

    @Test(dataProvider = "dataPost")
    public void test(String foodName, String cookType){


        baseURI = "https://reqres.in/api";
        basePath = "/users";

        JSONObject req = new JSONObject();
        
        req.put("foodName", foodName);
        req.put("cookType", cookType);

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Content-Type", "application/json")
            .body(req.toJSONString())
        .when()
            .post(baseURI+basePath)
        .then()
            .statusCode(201)
            .log().all();
    }
    
}
