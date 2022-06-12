package reqres.datadriven;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class auth_user_test {

    @Test
    public void data(){
        // basic auth
        baseURI = "https://the-internet.herokuapp.com/";
        basePath = "/basic_auth";
        RequestSpecification httpRequest = given().auth()
            .basic("admin", "admin")
            .header("Content-Type", "application/json");
        Response res = httpRequest.get(baseURI+basePath);
        ResponseBody body = res.body();
        System.out.println("Data from login"+body.asPrettyString());
    }
}
