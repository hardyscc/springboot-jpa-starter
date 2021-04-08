package com.example.sjs.util;

import javax.persistence.AttributeConverter;

public abstract class StringValuedEnumConverter<T extends Enum<?> & StringValuedEnum> implements AttributeConverter<T, String> {

    public abstract Class<T> getEnumClass();

    @Override
    public T convertToEntityAttribute(String dataValue) {
        if (dataValue == null) {
            return null;
        }

        return StringValuedEnumReflect.getEnumFromValue(this.getEnumClass(), dataValue);
    }

    @Override
    public String convertToDatabaseColumn(T enumValue) {
        if (enumValue == null) {
            return null;
        }

        return enumValue.getDataValue();
    }
}