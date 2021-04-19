package com.example.sjs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestVerProp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testVerPropSeq")
    @SequenceGenerator(name = "testVerPropSeq", sequenceName = "sq_test_ver_prop")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;
}
