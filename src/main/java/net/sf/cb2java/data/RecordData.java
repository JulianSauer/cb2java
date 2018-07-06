package net.sf.cb2java.data;

import net.sf.cb2java.types.CopybookElement;
import net.sf.cb2java.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple representation of data
 */
public class RecordData extends CopybookElement {

    private Object value;

    public RecordData(String name, int level, int length, Type type, Object value) {
        super(name, level, length, type);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<RecordData> getChildrenAsRecordData() {
        List<RecordData> data = new ArrayList<>();
        for (CopybookElement element : getChildren()) {
            if (element.getClass().equals(RecordData.class))
                data.add((RecordData) element);
        }
        return data;
    }

}
