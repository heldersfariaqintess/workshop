package org.qintess.utils;

import static org.qintess.utils.StringUtils.normalizarNull;

public class SqlUtils {

    public static String tratarAspasSimples(String str) {
        if (str != null) {
            return str.replace("'", "''");
        }
        return null;
    }

    public static String getStringSql(Object obj) {
        String str = normalizarNull(obj);

        if (str != null) {

            str = tratarAspasSimples(str);

            if (str.length() == 0) {
                return "''";
            } else {
                return "'" + str + "'";
            }
        }
        return null;
    }
}
