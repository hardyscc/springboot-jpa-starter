package com.example.sjs.entity;

import com.example.sjs.entity.base.BaseEntity;
import com.example.sjs.udt.RecordStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@IdClass(MessagePk.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class Message extends BaseEntity {

    @Id
    private String hospCode;

    @Id
    private String code;

    @Lob
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @Column(nullable = false)
    private RecordStatus status;
}