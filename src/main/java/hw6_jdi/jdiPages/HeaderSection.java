package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

public class HeaderSection extends Section {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a")
    public static Menu headerMenu;
    @FindBy(id = "user-icon")
    public Icon userIcon;
    @Css("div.logout button")
    public Button logout;

    public void logout() {
        if (logout.isHidden()) {
            userIcon.click();
        }
        logout.click();
    }

}
