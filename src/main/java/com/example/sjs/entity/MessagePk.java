package com.example.sjs.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagePk implements Serializable {

    private static final long serialVersionUID = -2650878960402307331L;

    @Column
    private String hospCode;
    @Column
    private String code;
}
