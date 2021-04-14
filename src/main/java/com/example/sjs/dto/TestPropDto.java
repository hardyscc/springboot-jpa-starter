package com.example.sjs.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestPropDto {

    private String name;

    private String value;
}
