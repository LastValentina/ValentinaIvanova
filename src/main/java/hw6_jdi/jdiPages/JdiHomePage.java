package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw6_jdi.entities.User;
import hw6_jdi.forms.LoginForm;


public class JdiHomePage extends WebPage {
    @FindBy(css = ".benefit")
    public WebList benefits;
    @FindBy(id = "user-name")
    public Label userName;
    @FindBy(id = "user-icon")
    public Icon userIcon;
    @Css("div.logout button")
    public Button logout;

    public LoginForm loginForm;
    public HeaderSection headerSection;
    public LeftMenuSection leftMenuSection;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public int getBenefitsCount() {
        return benefits.size();
    }

    public String getUserName() {
        return userName.getText();
    }

    //   public void logout() {
    //      if(logout.isDisabled()) {  userIcon.click(); }
    //       logout.click();
//    }

}
