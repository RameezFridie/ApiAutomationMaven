import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoTest {
    @Test
    public void registrationSuccessful() {
        RestAssured.baseURI = "https://reqres.in/api";
        String jsonBody = "{\"name\":\"Rameez\",\"job\":\"Training\",\"email\":\"ab@cd.com\"}";
        given().
                body(jsonBody).log().all().
                when().
                post("/user").
                then().
                log().all().
                assertThat().statusCode(HttpStatus.SC_CREATED);
    }
}