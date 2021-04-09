package com.example.sjs.controller;

import com.example.sjs.dto.TestDTO;
import com.example.sjs.entity.Test;
import com.example.sjs.entity.TestVer;
import com.example.sjs.entity.TestVerProp;
import com.example.sjs.repository.TestRepository;
import com.example.sjs.repository.TestVerRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TestController {

    private final TestRepository testRepository;
    private final TestVerRepository testVerRepository;

    @Operation(tags = "Test")
    @GetMapping(path = "/test/{code}")
    public Test getTest(@PathVariable String code) {
        log.info("getTest {}", code);

        return this.testRepository.findById(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Operation(tags = "Test")
    @PostMapping(path = "/test")
    public Test createTest(@RequestBody TestDTO input) {
        log.info("createTest {}", input);

        if (this.testRepository.existsById(input.getCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Test test = Test.builder()
                .code(input.getCode())
                .build();
        test = this.testRepository.save(test);

        List<TestVerProp> props = input.getProps().stream().map((prop) ->
                TestVerProp.builder().name(prop.getName()).value(prop.getValue()).build()
        ).collect(Collectors.toList());

        TestVer testVer = TestVer.builder()
                .name(input.getName())
                .test(test)
                .props(props)
                .version(1)
                .build();
        testVer = this.testVerRepository.save(testVer);

        test.setTestVerLatest(testVer);
        this.testRepository.save(test);

        test.setTestVers(Collections.singletonList(testVer));
        return test;
    }

    @Operation(tags = "Test")
    @PutMapping(path = "/test")
    public Test updateTest(@RequestBody TestDTO input) {
        log.info("updateTest {}", input);

        Test test = this.testRepository.findById(input.getCode()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );

        TestVer testVer = test.getTestVers().get(0);
        if (!testVer.getName().equals(input.getName())) {

            List<TestVerProp> props = input.getProps().stream().map((prop) ->
                    TestVerProp.builder().name(prop.getName()).value(prop.getValue()).build()
            ).collect(Collectors.toList());

            testVer = testVer.toBuilder()
                    .id(null)
                    .name(input.getName())
                    .props(props)
                    .version(testVer.getVersion() + 1)
                    .build();
            testVer = this.testVerRepository.save(testVer);

            test.setTestVerLatest(testVer);
            this.testRepository.save(test);

            test.getTestVers().add(0, testVer);
        }

        return test;
    }
}
