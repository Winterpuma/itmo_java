import TestData.FinalField;
import TestData.ListField;
import TestData.PrivateNotInitFloatField;
import TestData.PublicDoubleField;
import converter.Converter;
import converter.ReflectionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class ConverterTest {

    static Converter converter;

    @BeforeAll
    static void setupThis(){
        converter = new ReflectionConverter();
    }

    @Test
    void testConvertToMapNull() throws IllegalAccessException {
        Assertions.assertNull(converter.convertToMap(null));
    }

    @Test
    void testConvertToMapPublicField() throws IllegalAccessException {
        var dataClass = new PublicDoubleField();

        var result = converter.convertToMap(dataClass);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass.expectedMap(), result);
    }

    @Test
    void testConvertToMapPrivateNotInitField() throws IllegalAccessException {
        var dataClass = new PrivateNotInitFloatField();

        var result = converter.convertToMap(dataClass);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass.expectedMap(), result);
    }

    @Test
    void testConvertToMapFinalField() throws IllegalAccessException {
        var dataClass = new FinalField();

        var result = converter.convertToMap(dataClass);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass.expectedMap(), result);
    }

    @Test
    void testConvertToMapListField() throws IllegalAccessException {
        var dataClass = new ListField();

        var result = converter.convertToMap(dataClass);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass.expectedMap(), result);
    }

    @Test
    void testConvertToObjNull() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Assertions.assertNull(converter.convertToObject(PublicDoubleField.class,null));
    }

    @Test
    void testConvertToObjPublicField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new PublicDoubleField();
        var dataMap = dataClass.expectedMap();

        var result = converter.convertToObject(PublicDoubleField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass, result);
    }
//todo
    @Test
    void testConvertToObjPrivateNotInitField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new PrivateNotInitFloatField();
        var dataMap = dataClass.expectedMap();

        var result = converter.convertToObject(PrivateNotInitFloatField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass, result);
    }

    @Test
    void testConvertToObjFinalField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new FinalField();
        var dataMap = dataClass.expectedMap();

        var result = converter.convertToObject(FinalField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass, result);
    }

    @Test
    void testConvertToObjListField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new ListField();
        var dataMap = dataClass.expectedMap();

        var result = converter.convertToObject(ListField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass, result);
    }

    @Test
    void testConvertToObjIntToDoubleField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new PublicDoubleField();
        var dataMap = dataClass.expectedMapButInt();

        var result = converter.convertToObject(PublicDoubleField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dataClass, result);
    }

    @Test
    void testConvertToObjStringToDoubleField() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var dataClass = new PublicDoubleField();
        dataClass.myPublicDouble = 999;
        var dataMap = dataClass.expectedMapButString();

        var result = converter.convertToObject(PublicDoubleField.class, dataMap);

        Assertions.assertNotNull(result);
        Assertions.assertNotEquals(dataClass, result);
    }
}
