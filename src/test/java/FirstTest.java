import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Contstants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        //логируем запрос
        given().log().ifValidationFails().
                when().get(SWAPI_GET_PEOPLE + "1").
                // логируем ответ
                then().log().body().statusCode(200);
    }
}
