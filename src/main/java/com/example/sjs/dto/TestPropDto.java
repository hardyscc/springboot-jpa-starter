package com.example.sjs.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
