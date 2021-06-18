package com.example.sjs.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@Getter
@Setter
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
