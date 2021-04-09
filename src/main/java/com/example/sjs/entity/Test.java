package com.example.sjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    @Id
    private String code;

    @OneToOne
    @JoinColumn
    private TestVer testVerLatest;

    @JsonIgnore
    @OneToMany(mappedBy = "test")
    @OrderBy("version desc")
    private List<TestVer> testVers;
}
