package com.example.sjs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class TestPropDto {

    @NotBlank
    @Schema(defaultValue = "name1")
    private String name;

    @NotBlank
    @Schema(defaultValue = "value1")
    private String value;
}
