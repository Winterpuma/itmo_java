package TestData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListField {
    private List<Integer> myList;

    public Map<String, Object> expectedMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("myList", myList);
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

        final ListField other = (ListField) obj;

        return this.myList == other.myList;
    }
}
