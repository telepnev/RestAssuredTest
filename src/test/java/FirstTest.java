import config.TestConfig;
import org.testng.annotations.Test;
import static constants.Contstants.PATH.SWAPI_PATH;
import static constants.Contstants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        //логируем запрос
        given().log().uri().
                when().get(SWAPI_GET_PEOPLE + "1").
                // логируем ответ
                then().log().body().statusCode(200);
    }
    @Test
    public void getSomeFiledInResponse() {
        given().spec(requestSpecificationForSwapiTest).log().uri().
        when().get(SWAPI_PATH).
        then().body("people", equalTo("http://swapi.dev/api/people/")).log().body();
    }
    @Test
    public void getSomeFiledInResponseWithIndexAssertion() {
        given().spec(requestSpecificationForSwapiTest).log().uri().
        when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
        then().
        body("count", equalTo(82)).
      body("results.name[0]",equalTo("Luke Skywalker")).
      body("results.eye_color[5]",equalTo("blue")).
           // body("created",equalTo("2014-12-09T13:50:51.644000Z")).
//          body("films[1]",equalTo("http://swapi.dev/api/films/2/")).
       log().body();
    }
}
