package com.example.sjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestVer {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(length = 36)
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Test test;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int version;
}
