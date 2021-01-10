package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class LeftMenuSection extends Section {
    @UI(".sidebar-menu span<[*'%s']<<")
    public static Menu leftMenu;

}
