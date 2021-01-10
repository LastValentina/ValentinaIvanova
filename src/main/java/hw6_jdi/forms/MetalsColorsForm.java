package hw6_jdi.forms;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6_jdi.complexelements.DropList;
import hw6_jdi.complexelements.MultiCheckList;
import hw6_jdi.entities.MetalsColors;

public class MetalsColorsForm extends Form<MetalsColors> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons radio_odd;
    @FindBy(name = "custom_radio_even")
    public RadioButtons radio_even;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public MultiCheckList elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown color;
    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public static Dropdown metal;

    @JDropdown(root = "//div[@ui='droplist']", value = "//button", list = "//li",
            expand = "//*[contains(@class, 'caret')]")
    public DropList vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    public void fillForm(MetalsColors values) {
        radio_odd.select(values.getRadio_odd());
        radio_even.select(values.getRadio_even());
        elements.select(values.getElements());
        metal.select(values.getMetal());
        color.select(values.getColor());
        vegetables.select(values.getVegetables());
    }
}
