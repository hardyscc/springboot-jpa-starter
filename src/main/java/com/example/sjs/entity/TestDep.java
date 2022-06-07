package com.example.sjs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDep {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testDepSeq")
    @SequenceGenerator(name = "testDepSeq", sequenceName = "sq_test_dep", initialValue = 100001)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Test ownerTest;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Test depTest;

    @Column(name = "dep_test_code", insertable = false, updatable = false)
    private String depTestCode;

    @Column(nullable = false)
    private Integer sortSeq;
}
