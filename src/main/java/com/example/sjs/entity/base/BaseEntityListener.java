package com.example.sjs.entity.base;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class BaseEntityListener {

    @PreUpdate
    @PrePersist
    public void preSave(BaseEntity o) {
        Date today = new Date();
        if (o.getCreateDate() == null) {
            o.setCreateDate(today);
        }
        o.setUpdateDate(today);
    }
}
