package com.example.sjs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class TestPropDto {

    @NotBlank
    private String name;

    @NotBlank
    private String value;
}
