package com.example.sjs.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Getter
@Setter
abstract public class VersionEntity extends BaseEntity {

    @Version
    @Column(nullable = false)
    private Integer version;
}
