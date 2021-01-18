package hw6_jdi.enums;

public enum Menuitem {
    Home,
    ContactForm("Contact form"),
    Support,
    Dates,
    Service,
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    UserTable("User Table"),
    TableWithPages("Table with pages"),
    DifferentElements("Different elements"),
    MetalsColors("Metals & Colors");

    public String value;

    Menuitem() {
        value = toString();
    }

    Menuitem(String value) {
        this.value = value;
    }
}
