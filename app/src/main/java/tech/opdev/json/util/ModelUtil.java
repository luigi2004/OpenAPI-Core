package tech.opdev.json.util;

import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.JsonValue.ValueType;
import lombok.Value;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ModelUtil {
    public <T> T  from(JsonObject jsonObject, Class<T> classType) {
        Field[] properties = classType.getDeclaredFields();
        jsonObject.keySet().containsAll(Arrays.stream(properties).map(f->f.getName()).collect(Collectors.toList()));
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

    @Value
    class Arguement {
        private Class<?> type;
        private String name;
    }

    public <T> T from(JsonObject jsonObject, Constructor<?>[] constructors){
        ConstructorProperties properties = null;
        Constructor<?> ctor = null;
        for (Constructor<?> constructor : constructors) {
            properties = constructor.getAnnotation(ConstructorProperties.class);
            if(properties != null){
                ctor = constructor;
                break;
            }
        }
        
        Class<?>[] types = ctor.getParameterTypes();
        List<Arguement> args = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            args.add(new Arguement(types[i], properties.value()[i]));
        }

        if(ctor != null) {
            List<Object> m = new ArrayList<>();
            for (Arguement arg : args) {
                JsonValue value = jsonObject.get(arg.getName());
                switch (value.getValueType()) {
                    case ARRAY:
                        JsonArray array = value.asJsonArray();
                        // for each value recusively get object
                        // get type from constructor
                        break;
                    case OBJECT:
                        //recursively get object
                        
                    case NUMBER:
                        // switch case for float int long double
                        
                    case STRING:
                        // normal string
                        m.add(value.toString());
                        break;
                    case FALSE:

                    case TRUE:
                        // normal boolean
                    default:
                        //unknown case should never happen
                        break;
                }
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
        } else if(clazz.isArray() || clazz.isAssignableFrom(Collection.class)){
            return ValueType.ARRAY;
        } else {
            return ValueType.OBJECT;
        }
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
