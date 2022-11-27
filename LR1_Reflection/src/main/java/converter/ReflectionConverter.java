package converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectionConverter implements Converter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public Map<String, Object> convertToMap(Object object) throws IllegalAccessException {
        if (object == null)
            return  null;

        Map<String, Object> map = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            map.put(field.getName(), getFieldValue(object, field));
        }
        return map;
    }

    @Override
    public Object convertToObject(Class<?> clazz, Map<String, Object> map) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (map == null)
            return null;

        Object object = initialize(clazz);
        setFields(clazz, object, map);
        return object;
    }

    private Object getFieldValue(Object object, Field field) throws IllegalAccessException {
        boolean originalAccessModifier = field.canAccess(object);
        field.setAccessible(true);
        Object fieldValue = field.get(object);
        field.setAccessible(originalAccessModifier);
        return fieldValue;
    }

    private void setFields(Class<?> clazz, Object object, Map<String, Object> map) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            Object value = map.get(fieldName);
            if (value != null) {
                try {
                    setFieldValue(object, field, value);
                }
                catch (Exception e)
                {
                    System.out.println(ANSI_YELLOW + "error in setFieldValue" + ANSI_RESET);
                }
            }
        }
    }

    private void setFieldValue(Object object, Field field, Object value) throws IllegalAccessException {
        boolean accessModifier = field.canAccess(object);
        field.setAccessible(true);
        field.set(object, value);
        field.setAccessible(accessModifier);
    }

    private Object initialize(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getConstructors()[0];
        return constructor.newInstance();
    }
}
