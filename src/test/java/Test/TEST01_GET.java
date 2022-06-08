package Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class TEST01_GET {

    @Test
    void test_01() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    void test_02() {
        given()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("data.id[0]", equalTo(7));
    }
}
