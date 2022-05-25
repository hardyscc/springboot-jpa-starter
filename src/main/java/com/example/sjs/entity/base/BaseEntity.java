package com.example.sjs.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
@Getter
@Setter
abstract public class BaseEntity {

    @Column(nullable = false)
    private Date updateDate;

    @Column(nullable = false)
    private Date createDate;
}
