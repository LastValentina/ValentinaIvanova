package hw6_jdi.entities;

import java.util.Arrays;

public class MetalsColorsJ {
    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
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

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String getRadio1() {
        return Integer.toString(summary[0]);
    }

    public String getRadio2() {
        return Integer.toString(summary[1]);
    }

    public int getSum() {
        return summary[0] + summary[1];
    }

    public String getElementsAsString() {
        StringBuilder s = new StringBuilder();
        for (String component : elements) {
            s.append(component);
            s.append(", ");
        }
        return s.toString().substring(0, s.length() - 2);
    }

    public String getVegetablesAsString() {
        StringBuilder s = new StringBuilder();
        for (String component : vegetables) {
            s.append(component);
            s.append(", ");
        }
        return s.toString().substring(0, s.length() - 2);
    }


    public MetalsColorsResult convertToResultClass() {
        MetalsColorsResult result = new MetalsColorsResult();
        String su = Integer.toString(getSummary()[0] + getSummary()[1]);
        result.setSummary(su);
        result.setElements(getElementsAsString());
        result.setMetals(getMetals());
        result.setColor(getColor());
        result.setVegetables(getVegetablesAsString());
        return result;
    }

    @Override
    public String toString() {
        return "MetalsColorsJ{" +
                "summary=" + Arrays.toString(summary) +
                ", elements=" + Arrays.toString(elements) +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + Arrays.toString(vegetables) +
                '}';
    }
}
