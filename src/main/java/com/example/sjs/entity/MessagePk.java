package com.example.sjs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessagePk implements Serializable {

    private static final long serialVersionUID = -2650878960402307331L;

    @Column
    private String hospCode;
    @Column
    private String code;
}
