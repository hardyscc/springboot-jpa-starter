package com.example.sjs.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class TestDto {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @Valid
    private List<TestPropDto> props;
}
