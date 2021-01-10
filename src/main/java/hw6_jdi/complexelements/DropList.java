package hw6_jdi.complexelements;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import org.openqa.selenium.WebElement;

public class DropList extends Dropdown {

    @Override
    public void select(String value) {
        expander().click();                     //       if (!IsExpanded())  Expand.click();
        String def = getText();
        for (WebElement listOption : list()) {
            if (listOption.getText().trim().equals(def))
                listOption.click();
        }

        String[] values = value.split(", ");
        for (String val : values) {
            for (WebElement listOption : list()) {
                if (listOption.getText().trim().equals(val))
                    listOption.click();
            }
        }
    }
}

