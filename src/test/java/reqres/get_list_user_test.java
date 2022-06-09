package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class get_list_user_test {

    // marking test
    @Test
    public void checkId(){
        // make a get request
        given().
            get("https://reqres.in/api/users?page=1")
        .then()
            // check the status code
            .statusCode(200)
            // check the data, the first id is 8 or no
            .body("data.id[0]", equalTo(1))
            // return all of the data
            .log().all();
    }

    @Test
    public void checkUser(){
        given()
            .get("https://reqres.in/api/users?page=1")
        .then()
            //looking for data has certain items
            .body("data.first_name", hasItems("George", "Janet"));
    }
    
}
