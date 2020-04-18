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
    @Test
    public void PostWithJson() {
        String postBody = "{\n" +
                "\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "\n" +
                "}";
        given().body(postBody).log().uri().
                when().post(PlacesHolder_POST).
                then().log().body().statusCode(201);

        //  для пост запросов приходят 201 который говорит что создается какой то обьект на сервере, но это не точно))
    }
    @Test
    public void PostWithXML() {

        String postXML = "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Evgeniy</FirstName>\n" +
                "      <LastName>Telepnev</LastName>\n" +
                "      <ContactNo>LaLaLaLaLa</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>";
        given().body(postXML).log().uri().
                when().post("").
                then().log().body().statusCode(200);
    }

}
