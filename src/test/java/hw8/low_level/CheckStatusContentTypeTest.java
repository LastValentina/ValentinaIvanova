package hw8.low_level;

import hw8.service.ServiceUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static hw8.dto.Const.PARAMETR_TEXT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class CheckStatusContentTypeTest {
    String uri = new ServiceUrl().getServiceUrl();

    @Test(description = "Json content type verification",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkContentTypeTest(String testId, String wrongWord) {
        RestAssured.given().param(PARAMETR_TEXT, wrongWord)
                .when().get(uri).prettyPeek()
                .then()
                .assertThat().contentType(ContentType.JSON);
    }

    @Test(description = "status code and contains test",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkStatusAndBodyTest(String testId, String wrongWord) {
        RestAssured.given().param(PARAMETR_TEXT, wrongWord)
                .when().get(uri).prettyPeek()
                .then().statusCode(SC_OK)
                .body("word[0]", equalTo(wrongWord));   //Matchers.is(wrongWord)
    }

    @Test(enabled = false, description = "status code 200 verification")
    public void checkStatusSimpleTest() {
        RestAssured.given().get(uri).then().statusCode(SC_OK);
    }

}
