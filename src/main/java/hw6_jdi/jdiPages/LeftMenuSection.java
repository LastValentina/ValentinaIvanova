package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class LeftMenuSection extends Section {
    @FindBy(css = "ul.sidebar-menu span")             //@UI(".sidebar-menu span<[*'%s']<<")
    public static Menu leftMenu;

}
