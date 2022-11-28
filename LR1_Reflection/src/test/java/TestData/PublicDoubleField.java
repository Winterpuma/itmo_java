package TestData;

import java.util.HashMap;
import java.util.Map;

public class PublicDoubleField {
    public double myPublicDouble = 7;

    public Map<String, Object> expectedMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("myPublicDouble", myPublicDouble);
        return map;
    }

    public Map<String, Object> expectedMapButInt() {
        Map<String, Object> map = new HashMap<>();
        map.put("myPublicDouble", (int)myPublicDouble);
        return map;
    }

    public Map<String, Object> expectedMapButString() {
        Map<String, Object> map = new HashMap<>();
        map.put("myPublicDouble", "string");
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

        final PublicDoubleField other = (PublicDoubleField) obj;

        return this.myPublicDouble == other.myPublicDouble;
    }
}
