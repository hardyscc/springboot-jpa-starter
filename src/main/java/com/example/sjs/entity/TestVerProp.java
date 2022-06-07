package com.example.sjs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestVerProp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testVerPropSeq")
    @SequenceGenerator(name = "testVerPropSeq", sequenceName = "sq_test_ver_prop", initialValue = 100001)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "\"value\"", nullable = false)
    private String value;
}
