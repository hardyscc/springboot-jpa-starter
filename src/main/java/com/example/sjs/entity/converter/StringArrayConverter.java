package com.example.sjs.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StringArrayConverter implements AttributeConverter<String[], String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        try {
            return this.objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        try {
            return this.objectMapper.readValue(dbData, String[].class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}