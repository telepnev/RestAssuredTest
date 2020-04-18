package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constants.Contstants.RunVeriable.path;
import static constants.Contstants.RunVeriable.server;

public class TestConfig {
    //Что бы этот метод выполнялся перед каждым тестовым методом добавим анатацию @BeforeClass

@BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
