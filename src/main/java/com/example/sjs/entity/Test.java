package com.example.sjs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.example.sjs.entity.base.VersionEntity;
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
