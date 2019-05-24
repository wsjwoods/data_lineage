package util;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 数据检查辅助类
 *
 * @author caviler
 */
public class Check {
    //~ Constructors -----------------------------------------------------------

    /**
     * 私有构造函数
     */
    private Check() {
    }

    //~ Methods ----------------------------------------------------------------

    public static boolean isEmpty(final boolean[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final byte[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final char[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final int[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final long[] value) {
        return null == value || value.length == 0;
    }

    public static boolean isEmpty(final Object[] a) {
        return null == a || a.length == 0;
    }

    public static boolean isEmpty(final CharSequence s) {
        return null == s || s.length() == 0;
    }

    public static boolean isEmpty(final String s) {
        return null == s || s.length() == 0;
    }

    // 为了防止 unchecked 编译警告而专门设置的函数
    public static boolean isEmpty(final Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }
    // 为了防止 unchecked 编译警告而专门设置的函数
    public static boolean isEmpty(final Map<?, ?> map) {
        return null == map || map.size() == 0;
    }
}

// End Check.java
