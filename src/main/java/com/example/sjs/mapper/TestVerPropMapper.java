package com.example.sjs.mapper;

import java.util.List;

import com.example.sjs.dto.TestPropDto;
import com.example.sjs.entity.TestVerProp;

import org.mapstruct.Mapper;

@Mapper
public interface TestVerPropMapper {

    List<TestVerProp> fromDtos(List<TestPropDto> test);
}
