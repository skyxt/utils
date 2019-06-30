import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具类
 * @author skyxt
 * Created 2019-06-30 18:09
 * Email skyxt.yang@gmail.com
 */
public class ReflectUtils {

    /**
     * 对象转为Map集合
     * @param object 待转换的对象
     * @return Map集合
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> object2Map(T object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        HashMap<String, Object> map = new HashMap<>(16);
        for(; clazz != Object.class; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(object));
            }
        }
        return map;
    }

}
