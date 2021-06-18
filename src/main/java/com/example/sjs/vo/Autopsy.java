package com.example.sjs.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Autopsy extends ApsGeneral {
    private Date dod;
}
