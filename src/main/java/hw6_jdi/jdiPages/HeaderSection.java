package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

public class HeaderSection extends Section {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li[1]/a")
    public Button headerHome;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li[2]/a")
    public Button headerContactForm;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li[3]/a")
    public Button headerService;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li[4]/a")
    public Button headerMetalsColors;
    @FindBy(id = "user-icon")
    public Icon userIcon;
    @Css("div.logout button")
    public Button logout;

    public void clickMetalsColorsMenu() {
        headerMetalsColors.click();
    }

    public void clickContactFromMenu() {
        headerContactForm.click();
    }

    public void clickHomeMenu() {
        headerHome.click();
    }

    public void clickServiceMenu() {
        headerService.click();
    }

    public void logout() {
        if (logout.isHidden()) {
            userIcon.click();
        }
        logout.click();
    }

}
