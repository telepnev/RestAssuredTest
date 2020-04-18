import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Contstants.Actions.PlacesHolder_GET;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolder extends TestConfig {

    @Test
    public void GET() {
        given().queryParam("postId", + 1).log().uri().
                when().get(PlacesHolder_GET).
                then().log().body().statusCode(200);

    }

}
