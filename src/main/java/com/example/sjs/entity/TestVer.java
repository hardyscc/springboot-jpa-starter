package com.example.sjs.entity;

import com.example.sjs.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class TestVer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testVerSeq")
    @SequenceGenerator(name = "testVerSeq", sequenceName = "sq_test_ver")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Test test;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String[] attributes;

    @Column(nullable = false)
    private Integer ver;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_ver_id")
    private List<TestVerProp> props;
}
