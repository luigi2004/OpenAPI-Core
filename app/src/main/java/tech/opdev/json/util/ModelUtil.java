package tech.opdev.json.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ModelUtil {
    public static <T> Collection<T> list(JsonArray array, Class<T> clazz) {
        Collection<T> ret = new ArrayList<>();
        if(array != null){
            array.stream().forEach(val -> {
                try {
                    ret.add(from(val.asJsonObject(), clazz));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            });
        }
        return Collections.emptyList();
    }

    public static <T> Map<String, T> map(JsonObject object, Class<T> clazz){
        Map<String, T> ret = new HashMap<>();
        if(object != null) {
            object.entrySet().stream().forEach(entry->{
                try {
                    ret.put(entry.getKey(), 
                    from(entry.getValue().asJsonObject(), clazz)
                    );
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            });
        }
        return ret;
    }

    public static <T> T from(JsonObject object, Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method method = clazz.getDeclaredMethod("from", JsonObject.class);
        return (T) method.invoke(null, object);
    }
}
