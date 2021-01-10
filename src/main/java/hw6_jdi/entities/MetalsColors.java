package hw6_jdi.entities;

public class MetalsColors {
    private String radio_odd;
    private String radio_even;
    private String elements;
    private String color;
    private String metal;
    private String vegetables;

    public MetalsColors(String radio_odd, String radio_even, String elements, String color, String metal, String vegetables) {
        this.radio_odd = radio_odd;
        this.radio_even = radio_even;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public String getRadio_odd() {
        return radio_odd;
    }

    public String getRadio_even() {
        return radio_even;
    }

    public String getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public String getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        return "MetalsColors{" +
                "radio_odd='" + radio_odd + '\'' +
                ", radio_even='" + radio_even + '\'' +
                ", elements='" + elements + '\'' +
                ", color='" + color + '\'' +
                ", metal='" + metal + '\'' +
                ", vegetables='" + vegetables + '\'' +
                '}';
    }
}
