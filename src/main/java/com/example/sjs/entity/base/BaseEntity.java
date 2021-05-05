package com.example.sjs.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

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
