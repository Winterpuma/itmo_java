package TestData;

import java.util.HashMap;
import java.util.Map;

public class PrivateNotInitFloatField {
    private float myNotInitFloat;

    public Map<String, Object> expectedMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("myNotInitFloat", myNotInitFloat);
        return map;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final PrivateNotInitFloatField other = (PrivateNotInitFloatField) obj;

        return this.myNotInitFloat == other.myNotInitFloat;
    }
}
