package com.example.sjs.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDto {

    private String code;

    private String name;

    private List<TestPropDto> props;
}
