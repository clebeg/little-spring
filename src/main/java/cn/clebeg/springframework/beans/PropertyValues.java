package cn.clebeg.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clebegxie
 */
public class PropertyValues extends PropertyValue {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyName.equals(propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
