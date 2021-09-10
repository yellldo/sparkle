package io.github.yellldo.core.mask;

import java.util.Arrays;

/**
 * ClassName : Mask<br>
 * Description : 掩码工具类<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 */
public class Mask {

    public static final char MASK_CHAR = '*';

    public static final char[] MASK_3 = new char[3];

    public static final char[] MASK_4 = new char[4];

    public static final char[] MASK_6 = new char[6];

    public static final char[] MASK_100 = new char[100];

    public static final char[] EMPTY_CHARS = new char[0];

    static {
        Arrays.fill(MASK_3, MASK_CHAR);
        Arrays.fill(MASK_4, MASK_CHAR);
        Arrays.fill(MASK_6, MASK_CHAR);
        Arrays.fill(MASK_100, MASK_CHAR);
    }

    private Mask() {

    }


    public static String mask(String str, int before, int after) {
        char[] chs = maskToChars(str, before, after);
        return toString(chs);
    }

    public static String mask(String str, int before, int after, int maskCount) {
        char[] chs = maskToChars(str, before, after, maskCount);
        return toString(chs);
    }


    public static char[] maskToChars(String str, int before, int after) {
        if (str == null) {
            return null;
        }
        char[] chs = str.toCharArray();
        if (chs.length == 0 || chs.length < before + after) {
            return chs;
        }
        System.arraycopy(MASK_100, before, chs, after, chs.length - before - after);
        return chs;
    }

    public static char[] maskToChars(String str, int before, int after, int maskCount) {
        if (str == null) {
            return null;
        }
        if (maskCount <= 0) {
            return maskToChars(str, before, after);
        }
        char[] chs = str.toCharArray();
        if (chs.length == 0 || chs.length <= before + after) {
            return chs;
        }
        if (maskCount > MASK_100.length) {
            maskCount = MASK_100.length;
        }
        char[] strs = new char[before + after + maskCount];
        System.arraycopy(chs, 0, strs, 0, before);
        System.arraycopy(chs, str.length() - after, strs, strs.length - after, after);
        System.arraycopy(MASK_100, 0, strs, before, maskCount);
        return strs;
    }


    private static String toString(char[] chs) {
        if (chs == null) {
            return null;
        }
        return new String(chs);
    }
}
