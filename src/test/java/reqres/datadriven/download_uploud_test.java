package reqres.datadriven;
import com.google.common.io.Files;
import com.google.common.net.MediaType;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class download_uploud_test {

    @Test
    public void uploud(){
        // TODO save as global variable in one class
        baseURI = "https://the-internet.herokuapp.com/";
        basePath = "/uploud";
        File file = new File("/Users/ASUS/Pictures/Screenshots/ikan.png");
    
        Response response = RestAssured
            .given()
            .multiPart("file", file, "multipart/from-data")
            .post(baseURI+basePath)
            .thenReturn();
            System.out.println(response.prettyPrint());
    }

    @Test
    public void download() {
        basePath = "/users";
        Response res = RestAssured
            .given()
                .log().all()
            .get(baseURI+basePath)
                .andReturn();
        // TODO undestanding why use byte
        byte[] bytes = res.getBody().asByteArray();
        File file = new File("/Users/ASUS/Pictures/Screenshots/promode.json");
        Files.write(file.toPath(), bytes);
    }

}
