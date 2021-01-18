package hw6_jdi.forms;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6_jdi.complexelements.DropList;
import hw6_jdi.complexelements.MultiCheckList;
import hw6_jdi.entities.MetalsColorsJ;

public class MetalsColorsForm extends Form<MetalsColorsJ> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons radio_odd;
    @FindBy(name = "custom_radio_even")
    public RadioButtons radio_even;
    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public MultiCheckList elements_f;
    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown color;
    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public static Dropdown metals;
    @JDropdown(root = "//div[@ui='droplist']", value = "//button", list = "//li",
            expand = "//*[contains(@class, 'caret')]")
    public DropList vegetables_f;

    @FindBy(id = "submit-button")
    public Button submit;

    public void fillForm(MetalsColorsJ values) {
        radio_odd.select(values.getRadio_odd());
        radio_even.select(values.getRadio_even());
        elements_f.select(values.getElements_f());
        metals.select(values.getMetals());
        color.select(values.getColor());
        vegetables_f.select(values.getVegetables_f());
    }

}
