package hw8.service;

import hw8.dto.CheckTextDto;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;

public class CheckTextService extends CommonService {
    String uriText = new ServiceUrl().getServiceUrl();

    public CheckTextDto[] getCheckText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return new CommonService().getWithParams(uriText, params)
                .getBody().as(CheckTextDto[].class);
    }

    public CheckTextDto[] getCheckTextWithLang(String text, String lang) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_LANG, lang);
        params.put(PARAMETR_TEXT, text);
        return new CommonService().getWithParams(uriText, params)
                .getBody().as(CheckTextDto[].class);
    }

    public CheckTextDto[] getCheckTextWithLangOptions(String text, String lang, String options) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_LANG, lang);
        params.put(PARAMETR_OPTIONS, options);
        params.put(PARAMETR_TEXT, text);
        return new CommonService().getWithParams(uriText, params)
                .getBody().as(CheckTextDto[].class);
    }

    public Response getResponseByMethod(String text, String method) {
        Map<String, String> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return new CommonService().getURL(method, uriText, params);
    }
}
