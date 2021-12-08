package com.example.sjs.entity;

import com.example.sjs.entity.base.VersionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test extends VersionEntity {

    @Id
    private String code;

    @OneToOne
    @JoinColumn
    private TestVer testVerLatest;

    @JsonIgnore
    @OneToMany(mappedBy = "test")
    @OrderBy("ver desc")
    private List<TestVer> testVers;

    @OneToMany(mappedBy = "ownerTest")
    @OrderBy("sortSeq")
    private List<TestDep> testDeps;
}
