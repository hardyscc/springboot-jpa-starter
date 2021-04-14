package com.example.sjs.controller;

import com.example.sjs.dto.TestDto;
import com.example.sjs.entity.Test;
import com.example.sjs.entity.TestVer;
import com.example.sjs.mapper.TestMapper;
import com.example.sjs.mapper.TestVerPropMapper;
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

@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TestController {

    private final TestRepository testRepository;
    private final TestVerRepository testVerRepository;
    private final TestMapper testMapper;
    private final TestVerPropMapper testVerPropMapper;

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
    public Test createTest(@RequestBody TestDto input) {
        log.info("createTest {}", input);

        if (this.testRepository.existsById(input.getCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Test test = this.testMapper.fromDto(input);
        test = this.testRepository.save(test);

        TestVer testVer = TestVer.builder()
                .name(input.getName())
                .test(test)
                .props(this.testVerPropMapper.fromDtos(input.getProps()))
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
    public Test updateTest(@RequestBody TestDto input) {
        log.info("updateTest {}", input);

        Test test = this.testRepository.findById(input.getCode()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );

        TestVer testVer = test.getTestVers().get(0);
        if (!testVer.getName().equals(input.getName())) {

            testVer = testVer.toBuilder()
                    .id(null)
                    .name(input.getName())
                    .props(this.testVerPropMapper.fromDtos(input.getProps()))
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
