package com.example.sjs.exception.impl;

import com.example.sjs.exception.BaseException;

public class BadRequestException extends BaseException {

    private static final long serialVersionUID = -730401358320524183L;

    public BadRequestException(String... message) {
        super(message);
    }
}
