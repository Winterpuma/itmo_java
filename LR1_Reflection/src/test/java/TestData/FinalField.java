package TestData;

import java.util.HashMap;
import java.util.Map;

public class FinalField {
    private final int myFinalInt = 9;

    public Map<String, Object> expectedMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("myFinalInt", myFinalInt);
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

        final FinalField other = (FinalField) obj;

        return this.myFinalInt == other.myFinalInt;
    }
}
