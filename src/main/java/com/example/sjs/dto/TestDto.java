package com.example.sjs.dto;

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
    private String code;

    @NotBlank
    private String name;

    @NotEmpty
    private String[] attributes;

    @Valid
    private List<TestPropDto> props;
}
