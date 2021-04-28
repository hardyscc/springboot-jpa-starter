package com.example.sjs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StringArrayConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        try {
            return new ObjectMapper().writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            // ignore
        }
        return null;
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        try {
            return new ObjectMapper().readValue(dbData, String[].class);
        } catch (JsonProcessingException e) {
            // ignore
        }
        return null;
    }
}