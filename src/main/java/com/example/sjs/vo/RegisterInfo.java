package com.example.sjs.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class RegisterInfo {
    private Autopsy autopsy;
    private Gynae gynae;
    private Cytology cytology;
}
