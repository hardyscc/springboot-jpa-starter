package com.example.sjs.udt;

import javax.persistence.Converter;

import com.example.sjs.util.StringValuedEnum;
import com.example.sjs.util.StringValuedEnumConverter;
import com.example.sjs.util.StringValuedEnumReflect;

public enum RecordStatus implements StringValuedEnum {
    Active("A", "Active"),
    Deleted("D", "Deleted");

    private final String dataValue;
    private final String displayValue;

    RecordStatus(String dataValue, String displayValue) {
        this.dataValue = dataValue;
        this.displayValue = displayValue;
    }

    public static RecordStatus dataValueOf(String dataValue) {
        return StringValuedEnumReflect.getEnumFromValue(RecordStatus.class, dataValue);
    }

    @Override
    public String getDataValue() {
        return this.dataValue;
    }

    @Override
    public String getDisplayValue() {
        return this.displayValue;
    }

    @Converter(autoApply = true)
    public static class EnumConverter extends StringValuedEnumConverter<RecordStatus> {
        @Override
        public Class<RecordStatus> getEnumClass() {
            return RecordStatus.class;
        }
    }
}
