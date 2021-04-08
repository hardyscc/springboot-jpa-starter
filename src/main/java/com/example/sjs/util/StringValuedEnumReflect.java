package com.example.sjs.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Utility class designed to inspect StringValuedEnums.
 */
public final class StringValuedEnumReflect {

    /**
     * Don't let anyone instantiate this class.
     *
     * @throws UnsupportedOperationException Always.
     */
    private StringValuedEnumReflect() {
        throw new UnsupportedOperationException("This class must not be instanciated.");
    }

    /**
     * All Enum constants (instances) declared in the specified class.
     *
     * @param enumClass Class to reflect
     * @return Array of all declared EnumConstants (instances).
     */
    private static <T extends Enum<?>> T[] getValues(Class<T> enumClass) {
        return enumClass.getEnumConstants();
    }

    /**
     * All possible string values of the string valued enum.
     *
     * @param enumClass Class to reflect.
     * @return Available string values.
     */
    public static <T extends Enum<?> & StringValuedEnum> String[] getStringValues(Class<T> enumClass) {
        T[] values = getValues(enumClass);
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getDataValue();
        }
        return result;
    }

    /**
     * Name of the enum instance which hold the especified string value.
     * If value has duplicate enum instances than returns the first occurency.
     *
     * @param enumClass Class to inspect.
     * @param value     String.
     * @return name of the enum instance.
     */
    public static <T extends Enum<?> & StringValuedEnum> T getEnumFromValue(Class<T> enumClass, String value) {
        if (value != null) {
            T[] values = getValues(enumClass);
            for (T t : values) {
                if (t.getDataValue().compareTo(value) == 0) {
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * All Enum constants (instances) declared in the specified class.
     *
     * @param enumClass Class to reflect
     * @return Array of all declared EnumConstants (instances).
     */
    @SafeVarargs
    public static <T extends Enum<?>> T[] getValuesExclude(Class<T> enumClass, T... excludes) {
        T[] values = getValues(enumClass);
        for (T exclude : excludes) {
            values = ArrayUtils.removeElement(values, exclude);
        }
        return values;
    }
}
