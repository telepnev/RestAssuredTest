import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FirstTest {

    @Test
    public void myFirstTest() {
        given().
                when().get("https://swapi.dev/api/people/1").
                then().statusCode(200);
    }
}
