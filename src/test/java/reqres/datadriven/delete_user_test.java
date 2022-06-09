package reqres.datadriven;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class delete_user_test {
    
    @DataProvider(name = "deleteUser")
    public Object[] dataDelete(){
        return new Object[] {
            4,
            5,
            6
        };
    }

    @Test(dataProvider = "deleteUser")
    public void test(int id) {
        when()
            .delete("https://reqres.in/api/users/" +id)
        .then()
            .statusCode(204);
    }
}
