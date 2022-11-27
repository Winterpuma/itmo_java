package converter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface Converter {
    Map<String, Object> convertToMap(Object object) throws IllegalAccessException;
    Object convertToObject(Class<?> clazz, Map<String, Object> map) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
