package com.example.sjs.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
public class TestDto {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotEmpty
    private String[] attributes;

    @Valid
    private List<TestPropDto> props;
}
