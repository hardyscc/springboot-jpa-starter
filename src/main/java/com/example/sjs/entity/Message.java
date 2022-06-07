package com.example.sjs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.sjs.entity.base.BaseEntity;
import com.example.sjs.udt.RecordStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(MessagePk.class)
@Getter
@Setter
public class Message extends BaseEntity {

    @Id
    private String hospCode;

    @Id
    private String code;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @JsonIgnore
    @Column(nullable = false)
    private RecordStatus status;
}