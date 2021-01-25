package hw8.low_level;

import hw8.service.CheckTextService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hw8.dto.Const.parametr_text;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;

public class RequestMethodTest {
    static String uri;

    @BeforeTest
    void setUpTest() {
        uri = new CheckTextService().getProperties().getProperty("service.uri");
    }

    @Test(description = "HTTP-methods test",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void httpMethodsTest(String testID, String wrongWord) {
        //GET
        RestAssured.given().log().all()
                .param(parametr_text, wrongWord)
                .get(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_OK);
        //POST
        RestAssured.given().log().all().param(parametr_text, wrongWord)
                .post(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_OK);
        //HEAD
        RestAssured.given().log().all().param(parametr_text, wrongWord)
                .head(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_OK);
        //OPTIONS
        RestAssured.given().param(parametr_text, wrongWord)
                .log().all()
                .options(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_OK);
        //PUT
        RestAssured.given().param(parametr_text, wrongWord)
                .log().all()
                .put(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_METHOD_NOT_ALLOWED);
        //PATCH
        RestAssured.given().param(parametr_text, wrongWord)
                .log().all()
                .patch(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_METHOD_NOT_ALLOWED);
        //DELETE
        RestAssured.given().param(parametr_text, wrongWord)
                .log().all()
                .delete(uri).prettyPeek()
                .then().log().all()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }

}
