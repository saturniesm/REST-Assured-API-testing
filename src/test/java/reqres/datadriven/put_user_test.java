package reqres.datadriven;

// TODO save import in one file
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.runtime.misc.ObjectEqualityComparator;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;



public class put_user_test {


    @DataProvider(name = "dataPut")
    public Object [][] data() {

        Object[][] data = new Object[][] {
            {"soto", "bakar"},
            {"ayam", "geprek"},
            {"ikan", "pepes"}
        };

        Object[] id = new Object[]  {
            4,
            6,
            7
        };

        return data;
    }

    @Test(dataProvider = "dataPost")
    public void test(String foodName, String cookType){
        JSONObject req = new JSONObject();
        
        req.put("foodName", foodName);
        req.put("cookType", cookType);

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Content-Type", "application/json")
            .body(req.toJSONString())
        .when()
            // TODO store the base variable in global
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }
    
}
