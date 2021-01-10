package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6_jdi.entities.MetalsColorsResult;
import hw6_jdi.forms.MetalsColorsForm;

public class JdiMetalsColorsPage extends WebPage {
    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultBlock;

    public HeaderSection headerSection;
    public LeftMenuSection leftMenuSection;
    public MetalsColorsForm metalsColorsForm;

    public MetalsColorsResult convertResultBlockToClass() {
        MetalsColorsResult metalsColorsResult = new MetalsColorsResult();
        for (UIElement element : resultBlock) {
            String field = element.getText().substring(0, element.getText().indexOf(':'));
            String value = element.getText().substring(element.getText().indexOf(':') + 2);
            switch (field) {
                case "Summary":
                    metalsColorsResult.setSummary(value);
                    break;
                case "Elements":
                    metalsColorsResult.setElements(value);
                    break;
                case "Color":
                    metalsColorsResult.setColor(value);
                    break;
                case "Metal":
                    metalsColorsResult.setMetals(value);
                    break;
                case "Vegetables":
                    metalsColorsResult.setVegetables(value);
                    break;
            }
        }
        return metalsColorsResult;
    }

}
