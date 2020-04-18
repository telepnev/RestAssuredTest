package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Contstants.RunVeriable.path;
import static constants.Contstants.RunVeriable.server;
import static constants.Contstants.Servers.REQUESTBIN_URL;
import static constants.Contstants.Servers.SWAPI_URL;

public class TestConfig {


    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader( "Content-Type", "application/xml" )
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();


    protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader( "Content-Type", "application/json" )
            .addCookie("testCookieJSON")
            .build();
    protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
    protected RequestSpecification requestSpecificationForSwapiTest = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();


    //Что бы этот метод выполнялся перед каждым тестовым методом добавим анатацию @BeforeClass
@BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;


        /*
        //может назначаться как на группу так и на точечные запросы.
        Выше будет создан универсальный запрос и который не будет ломать XML запрос.
        под каждый тип запроса.
    RequestSpecification RequestSpecificationForCurse = new RequestSpecBuilder()
            .addHeader( "Content-Type", "application/json" )
            .addCookie("testCookie")
            .build();
    RestAssured.requestSpecification = RequestSpecificationForCurse;

         */
    }
}


