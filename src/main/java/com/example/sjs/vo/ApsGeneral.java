package com.example.sjs.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
abstract class ApsGeneral {
    private String testCode;
    private String site;
}
