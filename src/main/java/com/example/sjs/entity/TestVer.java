package com.example.sjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestVer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testVerSeq")
    @SequenceGenerator(name = "testVerSeq", sequenceName = "SQ_TEST_VER")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Test test;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int version;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_ver_id")
    private List<TestVerProp> props;
}
