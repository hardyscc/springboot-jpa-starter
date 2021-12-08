package com.example.sjs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
public class TestDto {

    @NotBlank
    @Schema(defaultValue = "T01")
    private String code;

    @NotBlank
    @Schema(defaultValue = "Test 01")
    private String name;

    @NotEmpty
    @Schema(defaultValue = "[\"attr1\",\"attr2\"]")
    private String[] attributes;

    @Valid
    private List<TestPropDto> props;
}
