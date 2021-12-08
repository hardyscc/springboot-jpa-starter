package com.example.sjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDep {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testDepSeq")
    @SequenceGenerator(name = "testDepSeq", sequenceName = "sq_test_dep")
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
