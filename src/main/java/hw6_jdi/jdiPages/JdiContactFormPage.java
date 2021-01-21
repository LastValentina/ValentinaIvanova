package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class JdiContactFormPage extends WebPage {
    @FindBy(id = "first-name")
    public TextField firstName;
    @FindBy(id = "last-name")
    public TextField lastName;

    public HeaderSection headerSection;
    public LeftMenuSection leftMenuSection;

    public void inputFirstLastName(String first, String last) {
        firstName.setValue(first);
        lastName.setValue(last);
    }


}
