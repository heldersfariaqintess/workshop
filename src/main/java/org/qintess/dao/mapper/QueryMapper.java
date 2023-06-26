package org.qintess.dao.mapper;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface QueryMapper {

    static BigInteger mapBigInteger(Object object) {
        BigInteger numero = null;
        if (object != null) {
            numero = new BigInteger(object.toString());
        }
        return numero;
    }

    static BigInteger mapBigInteger(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapBigInteger(linha[posicao]);
    }

    static Long mapLong(Object object) {
        Long numero = null;
        if (object != null) {
            numero = Long.valueOf(object.toString());
        }
        return numero;
    }

    static Long mapLong(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapLong(linha[posicao]);
    }

    static String mapString(Object object) {
        String str = null;
        if (object != null) {
            str = object.toString();
        }
        return str;
    }

    static String mapString(Object[] linha, Integer posicao) {

        if (posicao == null) {
            return null;
        }

        return mapString(linha[posicao]);
    }

    static Integer mapInteger(Object object) {
        Integer integer = null;
        if (object != null) {
            integer = Integer.valueOf(object.toString());
        }
        return integer;
    }

    static Integer mapInteger(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapInteger(linha[posicao]);
    }

    static Double mapDouble(Object object) {
        Double doubleObject = null;
        if (object != null) {
            doubleObject = Double.valueOf(object.toString());
        }
        return doubleObject;
    }

    static Double mapDouble(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapDouble(linha[posicao]);
    }

    static LocalDateTime mapLocalDateTime(Object object) {
        LocalDateTime timeObject = null;
        if (object != null) {
            timeObject = ((Timestamp) object).toLocalDateTime();
        }
        return timeObject;
    }

    static LocalDateTime mapLocalDateTime(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapLocalDateTime(linha[posicao]);
    }

    static Boolean mapBoolean(Object object) {
        Boolean booleanObject = null;
        if (object != null) {
            if (object instanceof Number) {
                booleanObject = mapInteger(object) == 1;
            } else {
                booleanObject = Boolean.valueOf(object.toString());
            }
        }
        return booleanObject;
    }

    static Boolean mapBoolean(Object[] linha, Integer posicao) {
        if (posicao == null) {
            return null;
        }

        return mapBoolean(linha[posicao]);
    }

    @SuppressWarnings("unchecked")
    default  <T extends QueryMapper> T toMapper(){
        return (T) this;
    }
}