package com.example.sjs.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private final Integer statusCode;
    private final String[] message;
    private final String error;
}