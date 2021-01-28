package hw8.low_level;

import hw8.service.CheckTextService;
import hw8.service.ServiceUrl;
import org.testng.annotations.Test;

public class RequestMethodTest {
    String uri = new ServiceUrl().getServiceUrl();
    CheckTextService cts = new CheckTextService();

    @Test(description = "HTTP-methods test",
            dataProviderClass = hw8.TextDataProvider.class, dataProvider = "httpMethodsData")
    public void httpMethodsTest(String method, int status, String wrongWord) {

        cts.getResponseByMethod(wrongWord, method)
                //               .prettyPeek()
                .then().log().all()
                .statusCode(status);
    }

}
