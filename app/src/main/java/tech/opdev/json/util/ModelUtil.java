package tech.opdev.json.util;

import java.lang.reflect.Field;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue.ValueType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ModelUtil {
    public <T> T  from(JsonObject jsonObject, Class<T> classType) {
        Field[] properties = classType.getDeclaredFields();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        for (Field field : properties) {
            ValueType type = getValueType(field.getClass());
            switch (type) {
                case STRING:
                    
                    break;
            
                default:
                    break;
            }
        }
        return null;
    }

    public static ValueType getValueType(Class<?> clazz) {
        if(clazz.equals(String.class)) {
            return ValueType.STRING;
        } else if(clazz.equals(Integer.class) || clazz.equals(Long.class) || 
            clazz.equals(Float.class) || clazz.equals(Double.class)) {
            return ValueType.NUMBER;
        }
        return ValueType.OBJECT;
    }

    public boolean hasDefaultConstructor(Class<?> clazz) {
        try {
            clazz.getConstructor();
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}
