package hw8.service;

import hw8.dto.CheckTextDto;
import hw8.dto.ListOfCheckTextDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;
import static javax.ws.rs.HttpMethod.*;

public class CheckTextService extends CommonService {
    ServiceUrl su = new ServiceUrl();

    public CheckTextDto[] getCheckText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return this.getWithParams(su.getEpText(), params).getBody().as(CheckTextDto[].class);
    }

    public CheckTextDto[] getCheckTextWithLang(String text, String lang) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_LANG, lang);
        params.put(PARAMETR_TEXT, text);
        return this.getWithParams(su.getEpText(), params).getBody().as(CheckTextDto[].class);
    }

    public CheckTextDto[] getCheckTextWithLangOptions(String text, String lang, String options) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_LANG, lang);
        params.put(PARAMETR_OPTIONS, options);
        params.put(PARAMETR_TEXT, text);
        return this.getWithParams(su.getEpText(), params).getBody().as(CheckTextDto[].class);
    }

    public ListOfCheckTextDto[] getCheckTexts(String[] text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        Response response = this.getWithParams(su.getEpTexts(), params);
        return response.getBody().as(ListOfCheckTextDto[].class);
    }

    public String getResponseBody(String[] text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return this.getWithParams(su.getEpTexts(), params).getBody().asString();
    }

    public String getResponseBody(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return this.getWithParams(su.getEpText(), params).getBody().asString();
    }


    public Response getResponseByMethod(String text, String method) {
        Map<String, String> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        specification.queryParams(params);
        Response response = null;
        switch (method) {
            case GET:
                response = RestAssured.given(specification).get(su.getEpText());
                break;
            case POST:
                response = RestAssured.given(specification).post(su.getEpText());
                break;
            case PUT:
                response = RestAssured.given(specification).put(su.getEpText());
                break;
            case DELETE:
                response = RestAssured.given(specification).delete(su.getEpText());
                break;
            case PATCH:
                response = RestAssured.given(specification).patch(su.getEpText());
                break;
        }
        return response;
    }

}
