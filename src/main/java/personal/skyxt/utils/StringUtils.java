package personal.skyxt.utils;

import java.util.Arrays;

/**
 * 字符串工具类
 * @author skyxt
 * Created 2019-07-16 10:34
 * Email skyxt.yang@gmail.com
 */
public class StringUtils {
    private StringUtils() {}

    /**
     * 判断字符串是否为空
     * @param str
     *          原始字符串
     * @return
     *          是否为空
     */
    public static boolean isBlank(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * 判断字符串中是否有字符串是空
     * @param strs
     *          字符串列表
     * @return
     *          是否有任意字符串为空
     */
    public static boolean isAnyBlank(String... strs) {
        return Arrays.stream(strs).filter(StringUtils::isBlank).findAny().isPresent();
    }
}
