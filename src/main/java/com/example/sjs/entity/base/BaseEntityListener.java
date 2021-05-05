package com.example.sjs.entity.base;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

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
