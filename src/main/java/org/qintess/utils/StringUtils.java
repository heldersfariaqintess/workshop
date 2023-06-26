package org.qintess.utils;

public class StringUtils {

    public static boolean isNotBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(cs);
    }

    public static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    public static String normalizarNull(Object value) {

        if (value == null) {
            return null;
        }
        if ("null".equals(value) || "NULL".equals(value)) {
            return null;
        }
        return String.valueOf(value);
    }

    public static String emptyIfNull(String str) {
        if (str == null) {
            return "";
        }

        return str;
    }

    public static String toStringSafe(Object object) {
        if (object == null) {
            return null;
        }

        return object.toString();
    }

    public static String nullIfBlank(String str) {
        if (isNotBlank(str)) {
            return str;
        }

        return null;
    }

    public static boolean isEmpty(String str) {
        return org.apache.commons.lang3.StringUtils.isEmpty(str);
    }
}
