package personal.skyxt.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 * @author skyxt
 * Created 2019-07-16 10:21
 * Email skyxt.yang@gmail.com
 */
public class CollectionUtils {
    public static <T> T last(final List<T> data) {
        return data.get(data.size() - 1);
    }

    public static <T> String strings(final List<T> data, final String split) {
        final StringBuilder sb = new StringBuilder();
        if (null == data || data.isEmpty()) {
            sb.append("");
        }
        else {
            sb.append(split);
            for (final T obj : data) {
                sb.append(obj.toString());
                sb.append(split);
            }
        }
        return sb.toString();
    }

    public static <T> String strings(final List<T> data) {
        return strings(data, "\n");
    }

    public static <T> T[] concat(final T[] first, final T[]... rest) {
        int totalLength = first.length;
        for (final T[] array : rest) {
            totalLength += array.length;
        }
        final T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (final T[] array2 : rest) {
            System.arraycopy(array2, 0, result, offset, array2.length);
            offset += array2.length;
        }
        return result;
    }

    public static boolean isBlank(final byte[] data) {
        return null == data || 0 == data.length;
    }

    public static <T> boolean isBlank(final List<T> data) {
        return null == data || data.isEmpty();
    }

    public static <K, V> boolean isBlank(final Map<K, V> data) {
        return null == data || data.isEmpty();
    }

    public static <T> T get(final T[] data, int index) {
        final int len = data.length;
        if (index > len - 1) {
            index = len - 1;
        }
        return data[index];
    }

    public static int get(final int[] data, int index) {
        final int len = data.length;
        if (index > len - 1) {
            index = len - 1;
        }
        return data[index];
    }

    public static long get(final long[] data, int index) {
        final int len = data.length;
        if (index > len - 1) {
            index = len - 1;
        }
        return data[index];
    }

    public static double get(final double[] data, int index) {
        final int len = data.length;
        if (index > len - 1) {
            index = len - 1;
        }
        return data[index];
    }

    public static float get(final float[] data, int index) {
        final int len = data.length;
        if (index > len - 1) {
            index = len - 1;
        }
        return data[index];
    }
}
