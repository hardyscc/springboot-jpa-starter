package com.example.sjs.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.sjs.vo.RegisterInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Converter(autoApply = true)
public class RegisterInfoConverter implements AttributeConverter<RegisterInfo, String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(RegisterInfo attribute) {
        try {
            return this.objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public RegisterInfo convertToEntityAttribute(String dbData) {
        try {
            return this.objectMapper.readValue(dbData, RegisterInfo.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}