package com.example.sjs.exception.impl;

import com.example.sjs.exception.BaseException;

public class NotFoundException extends BaseException {

    private static final long serialVersionUID = -317384287570271849L;

    public NotFoundException(String... message) {
        super(message);
    }
}
