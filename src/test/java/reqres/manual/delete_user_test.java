package reqres.manual;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class delete_user_test {

    
    Map<String, Object> user = new HashMap<String, Object>();

    @Test
    public void delete_user(){
        given()
        .when()
            .delete("https://reqres.in/api/users/2")
        .then()
            .statusCode(204)
            .log().all();
    }
    
}
