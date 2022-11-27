import converter.Converter;
import converter.ReflectionConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {

    private static final Converter converter = new ReflectionConverter();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Demo myClass = new Demo();

        Map<String, Object> map = converter.convertToMap(myClass);
        System.out.println(map);
        System.out.println(myClass);
        System.out.println(converter.convertToObject(Demo.class, map));
        System.out.println(myClass.equals(converter.convertToObject(Demo.class, map)));
    }
}