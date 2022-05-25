package com.example.sjs.mapper;

import com.example.sjs.dto.TestDto;
import com.example.sjs.entity.Test;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TestMapper {

    @Mapping(target = "testVerLatest", ignore = true)
    @Mapping(target = "testVers", ignore = true)
    Test fromDto(TestDto testDto);
}
