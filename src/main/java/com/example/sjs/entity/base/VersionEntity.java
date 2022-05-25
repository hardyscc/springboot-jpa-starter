package com.example.sjs.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
abstract public class VersionEntity extends BaseEntity {

    @Version
    @Column(nullable = false)
    private Integer version;
}
