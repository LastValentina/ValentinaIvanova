package hw6_jdi.jdiPages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6_jdi.entities.MetalsColorsResult;
import hw6_jdi.forms.MetalsColorsForm;

public class JdiMetalsColorsPage extends WebPage {
    //   @FindBy(name = "custom_radio_odd")
    //   public RadioButtons oddRadioBtn;
//    @FindBy(name = "custom_radio_even")
//    public RadioButtons evenRadioBtn;
//    @FindBy(css = "input[type=checkbox]")
    //   public static Checklist elements;

    //   @FindBy(css = "input[type=checkbox]")
//    public static MultiCheckList elementsVer2;

    //  @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    //  public static Dropdown colors;
    //  @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    //  public static Dropdown metals;
    //  @UI("#vegetables")
    //  Checklist vegetables;
    //  @FindBy(css = "#vegetables .caret")
    //  WebElement vegetablesExpand;
    //  @FindBy(css = "#vegetables label")
    //  List<WebElement> vegetablesList;
    //  @FindBy(css = "#vegetables button")
    //  WebElement vegetablesValue;
    //  @FindBy(css = "#vegetables ul")
    //  WebElement vegetablesIsExpanded;

    //   @JDropdown(root = "//div[@ui='droplist']",
    //           value = "//button",
    //           list = "//li",
    //           expand = "//*[contains(@class, 'caret')]")
    //   DropList vegetables2;

    //   @FindBy(id = "submit-button")
    //   public Button submit;
    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultBlock;

    public HeaderSection headerSection;
    public LeftMenuSection leftMenuSection;
    public MetalsColorsForm metalsColorsForm;

    //   private boolean vegetablesIsExpanded() {
    //       return vegetablesIsExpanded.getAttribute("style").equals("display: block;");
    //   }
    //   public void selectVegetables(String[] values) {
    //       //      public void selectVegetables(String value) {
    //       if (!vegetablesIsExpanded())
    //           vegetablesExpand.click();
    ////       System.out.println(vegetablesList.get(2).isSelected());
    //       vegetablesList.get(2).click();
    //       for (String val : values) {                         //String[] values = value.split(", ");
    //           for (WebElement listOption : vegetablesList) {
    //               if (listOption.getText().trim().equals(val))
    //                   listOption.click();
    //           }
    //       }
    //   }


    //   public void fillMetalsColors(MetalsColorsJ dataSet) {
    //       oddRadioBtn.select(dataSet.getRadio1());
    //       evenRadioBtn.select(dataSet.getRadio2());
    //       elements.select(dataSet.getElements());
    //       metals.select(dataSet.getMetals());
    //       colors.select(dataSet.getColor());
    //       selectVegetables(dataSet.getVegetables());
    //       submit.click();
    //   }

    public MetalsColorsResult convertResultBlockToClass() {
        MetalsColorsResult metalsColorsResult = new MetalsColorsResult();
        for (UIElement element : resultBlock) {
            String field = element.getText().substring(0, element.getText().indexOf(':'));
            String value = element.getText().substring(element.getText().indexOf(':') + 2);
            switch (field) {
                case "Summary":
                    metalsColorsResult.setSummary(value);
                    break;
                case "Elements":
                    metalsColorsResult.setElements(value);
                    break;
                case "Color":
                    metalsColorsResult.setColor(value);
                    break;
                case "Metal":
                    metalsColorsResult.setMetals(value);
                    break;
                case "Vegetables":
                    metalsColorsResult.setVegetables(value);
                    break;
            }
        }
        return metalsColorsResult;
    }

    //   public void selectElements2(String values){
    //      elementsVer2.select(values);
    //  }

    //   public void selectVegetables2(String value) {  vegetables2.select(value);}

}
