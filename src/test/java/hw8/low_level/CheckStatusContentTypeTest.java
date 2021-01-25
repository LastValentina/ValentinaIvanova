package hw8.low_level;

import hw8.service.CheckTextService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static hw8.dto.Const.parametr_text;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class CheckStatusContentTypeTest {
    static String uri;

    @BeforeTest
    void setUpTest() {
        uri = new CheckTextService().getProperties().getProperty("service.uri");
    }

    @Test(description = "Json content type verification",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkContentTypeTest(String testId, String wrongWord) {
        RestAssured.given()
                .param(parametr_text, wrongWord)
                .when()
                .get(uri)
                .then()
                .assertThat().contentType(ContentType.JSON);
    }

    @Test(description = "status code and contains test",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkStatusAndBodyTest(String testId, String wrongWord) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .param(parametr_text, wrongWord)
                .when()
                .get(uri)
                .prettyPeek()
                .then()
                .statusCode(SC_OK)
                .body("word[0]", equalTo(wrongWord));   //Matchers.is(wrongWord)
    }

    @Test(enabled = false, description = "status code 200 verification")
    public void checkStatusSimpleTest() {
        //     RestAssured.given().get(uri).prettyPrint();
        RestAssured.given().get(uri).then().statusCode(SC_OK);
    }
}
