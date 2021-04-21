package com.example.sjs.exception.impl;

import com.example.sjs.exception.BaseException;

public class ConflictException extends BaseException {

    private static final long serialVersionUID = -7160572977773849040L;

    public ConflictException(String... message) {
        super(message);
    }
}
