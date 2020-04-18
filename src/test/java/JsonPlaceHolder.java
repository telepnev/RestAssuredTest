import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Contstants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolder extends TestConfig {

    @Test
    public void GET() {
        given().queryParam("postId", + 1).log().uri().
                when().get(PlacesHolder_GET).
                then().log().body().statusCode(200);

    }
    @Test
    public  void PUT() {

        String putBodyJson = "{\n" +
                "\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "\n" +
                "}";
        given().body(putBodyJson).log().uri().
                when().put(PlacesHolder_PUT).
                then().log().body().statusCode(200);
    }
    @Test
    public void Delete() {
        given().log().uri().
                when().delete(PlacesHolder_DELETE).
                then().log().body().statusCode(200);
    }

}
