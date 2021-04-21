package com.example.sjs.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class TestPropDto {

    @NotBlank
    private String name;

    @NotBlank
    private String value;
}
