package hw6_jdi.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetalsColorsJ {
    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    private String radio_odd;
    private String radio_even;
    private String elements_f;
    private String vegetables_f;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements_array(String[] elements) {
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

    public String getRadio_odd() {
        return Integer.toString(summary[0]);
    }

    public String getRadio_even() {
        return Integer.toString(summary[1]);
    }

    public String getElements_f() {
        return String.join(", ", elements);
    }

    public String getVegetables_f() {
        return String.join(", ", vegetables);
    }

    public int getSum() {
        return summary[0] + summary[1];
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

    public List<String> convertToResult() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(getSum()));
        list.add(getElements_f());
        list.add(getColor());
        list.add(getMetals());
        list.add(getVegetables_f());
        return list;
    }
}
