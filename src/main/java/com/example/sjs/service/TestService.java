package com.example.sjs.service;

import com.example.sjs.dto.TestDto;
import com.example.sjs.entity.Test;
import com.example.sjs.entity.TestDep;
import com.example.sjs.entity.TestVer;
import com.example.sjs.exception.impl.BadRequestException;
import com.example.sjs.exception.impl.NotFoundException;
import com.example.sjs.mapper.TestMapper;
import com.example.sjs.mapper.TestVerPropMapper;
import com.example.sjs.repository.TestDepRepository;
import com.example.sjs.repository.TestRepository;
import com.example.sjs.repository.TestVerRepository;
import com.example.sjs.vo.Autopsy;
import com.example.sjs.vo.Cytology;
import com.example.sjs.vo.Gynae;
import com.example.sjs.vo.RegisterInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final TestVerRepository testVerRepository;
    private final TestMapper testMapper;
    private final TestVerPropMapper testVerPropMapper;
    private final TestDepRepository testDepRepository;

    public Test getTest(String code) {
        return this.testRepository.findById(code).orElseThrow(
                () -> new NotFoundException(String.format("Test %s not found", code))
        );
    }

    public Test createTest(TestDto input) {
        if (this.testRepository.existsById(input.getCode())) {
            throw new BadRequestException(String.format("Test %s already exists", input.getCode()));
        }

        Test test = this.testMapper.fromDto(input);
        test = this.testRepository.save(test);

        TestDep testDep = this.testDepRepository.save(TestDep.builder()
                .ownerTest(test)
                .depTest(this.testRepository.getOne("dummy"))
                .sortSeq(1)
                .build());

        TestVer testVer = this.testVerRepository.save(TestVer.builder()
                .name(input.getName())
                .attributes(input.getAttributes())
                .test(test)
                .registerInfo(
                        RegisterInfo.builder()
                                .autopsy(Autopsy.builder()
                                        .testCode("T1")
                                        .dod(new Date())
                                        .build())
                                .gynae(Gynae.builder()
                                        .testCode("T2")
                                        .name("Testing")
                                        .type("myType")
                                        .build())
                                .cytology(Cytology.builder()
                                        .testCode("T3")
                                        .name("Testing2")
                                        .build())
                                .build())
                .props(this.testVerPropMapper.fromDtos(input.getProps()))
                .ver(1)
                .build());

        test.setTestVerLatest(testVer);
        this.testRepository.save(test);

        test.setTestDeps(Collections.singletonList(testDep));
        test.setTestVers(Collections.singletonList(testVer));
        return test;
    }

    public Test updateTest(TestDto input) {
        Test test = this.testRepository.findById(input.getCode()).orElseThrow(
                () -> new BadRequestException(String.format("Test %s not exists", input.getCode()))
        );

        TestVer testVer = test.getTestVers().get(0);
        if (!testVer.getName().equals(input.getName())) {

            testVer = this.testVerRepository.save(testVer.toBuilder()
                    .id(null)
                    .name(input.getName())
                    .props(this.testVerPropMapper.fromDtos(input.getProps()))
                    .registerInfo(testVer.getRegisterInfo())
                    .ver(testVer.getVer() + 1)
                    .build());

            test.setTestVerLatest(testVer);
            this.testRepository.save(test);

            test.getTestVers().add(0, testVer);
        }

        return test;
    }
}
