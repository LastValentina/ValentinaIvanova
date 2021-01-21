package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6_jdi.entities.MetalsColorsJ;
import hw6_jdi.forms.MetalsColorsForm;

import java.util.ArrayList;
import java.util.List;

public class JdiMetalsColorsPage extends WebPage {
    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultBlock;

    public HeaderSection headerSection;
    public LeftMenuSection leftMenuSection;
    public MetalsColorsForm metalsColorsForm;

    public List<String> checkResultBlock(MetalsColorsJ entity) {
        List<String> list = new ArrayList<>();
        for (UIElement element : resultBlock) {
            String field = element.getText().substring(0, element.getText().indexOf(':'));
            String value = element.getText().substring(element.getText().indexOf(':') + 2);
            list.add(value);
        }
        return list;
    }

}
