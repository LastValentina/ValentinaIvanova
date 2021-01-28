package hw8.service;

import hw8.dto.CheckTextDto;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.PARAMETR_TEXT;

public class CheckTextsService extends CommonService {
    ServiceUrl su = new ServiceUrl();
    String uriTexts = su.getBaseUrl() + su.getEpTexts();

    public CheckTextDto[] getCheckText(String[] text) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAMETR_TEXT, text);
        return new CommonService().getWithParams(uriTexts, params)
                .getBody().as(CheckTextDto[].class);
    }

}
