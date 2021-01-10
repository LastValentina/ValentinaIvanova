package hw6_jdi.complexelements;

import com.epam.jdi.light.elements.complex.Checklist;

public class MultiCheckList extends Checklist {

    @Override
    public void select(String value) {
        String[] values = value.split(", ");
        for (String val : values) {
            super.select(val);
        }
    }

}
