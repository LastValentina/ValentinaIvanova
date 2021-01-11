package pages.hw3;

public class ElementNameVisibility {
    private String name;
    private boolean visible;

    public ElementNameVisibility(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public boolean getVisible() {
        return visible;
    }
}
