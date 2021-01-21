package hw6_jdi;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6_jdi.jdiPages.JdiContactFormPage;
import hw6_jdi.jdiPages.JdiHomePage;
import hw6_jdi.jdiPages.JdiMetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    @Url("contacts.html")
    public static JdiContactFormPage jdiContactFormPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static String getTitle() {
        return WebPage.getTitle();
    }

}