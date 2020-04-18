package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Contstants.RunVeriable.path;
import static constants.Contstants.RunVeriable.server;
import static constants.Contstants.Servers.REQUESTBIN_URL;

public class TestConfig {


    protected RequestSpecification RequestSpecificationXml = new RequestSpecBuilder()
            .addHeader( "Content-Type", "application/xml" )
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();

    //Что бы этот метод выполнялся перед каждым тестовым методом добавим анатацию @BeforeClass
@BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        // этот реквест сюда потому что он с общей толпой пойдет, верхний сам по себе.
    RequestSpecification RequestSpecificationJson = new RequestSpecBuilder()
            .addHeader( "Content-Type", "application/json" )
            .addCookie("testCookieJSON")
            .build();

        RestAssured.requestSpecification = RequestSpecificationJson;

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


