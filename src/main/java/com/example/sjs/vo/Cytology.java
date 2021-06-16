package com.example.sjs.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Cytology extends ApsGeneral {
    private String name;
}
