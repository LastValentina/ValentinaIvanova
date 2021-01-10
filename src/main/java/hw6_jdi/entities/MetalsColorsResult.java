package hw6_jdi.entities;

import java.util.Objects;

public class MetalsColorsResult {
    private String summary;
    private String elements;
    private String color;
    private String metals;
    private String vegetables;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "MetalsColorsResult{" +
                "summary='" + summary + '\'' +
                ", elements='" + elements + '\'' +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables='" + vegetables + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetalsColorsResult)) return false;
        MetalsColorsResult that = (MetalsColorsResult) o;
        return Objects.equals(summary, that.summary) &&
                Objects.equals(elements, that.elements) &&
                Objects.equals(color, that.color) &&
                Objects.equals(metals, that.metals) &&
                Objects.equals(vegetables, that.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, elements, color, metals, vegetables);
    }
}
