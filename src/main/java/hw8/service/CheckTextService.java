package hw8.service;

import hw8.dto.CheckTextDto;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;

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

    public CheckTextDto[][] getCheckTexts(String[] text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        Response response = this.getWithParams(su.getEpTexts(), params);
        return response.getBody().as(CheckTextDto[][].class);
    }
}
