package com.example.sjs.mapper;

import com.example.sjs.dto.TestPropDto;
import com.example.sjs.entity.TestVerProp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TestVerPropMapper {

    List<TestVerProp> fromDtos(List<TestPropDto> test);
}
