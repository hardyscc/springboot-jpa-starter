package com.example.sjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.sjs.udt.RecordStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MessagePk.class)
@Data
public class Message {

    @Id
    private String hospCode;

    @Id
    private String code;

    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @Column(nullable = false)
    private RecordStatus status;
}