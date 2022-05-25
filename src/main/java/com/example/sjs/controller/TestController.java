package com.example.sjs.controller;

import javax.validation.Valid;

import com.example.sjs.dto.TestDto;
import com.example.sjs.entity.Test;
import com.example.sjs.service.TestService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @Operation(tags = "Test")
    @GetMapping(path = "/test/{code}")
    public Test getTest(@PathVariable String code) {
        log.info("getTest {}", code);

        return this.testService.getTest(code);
    }

    @Operation(tags = "Test")
    @PostMapping(path = "/test")
    public Test createTest(@Valid @RequestBody TestDto input) {
        log.info("createTest {}", input);

        return this.testService.createTest(input);
    }

    @Operation(tags = "Test")
    @PutMapping(path = "/test")
    public Test updateTest(@Valid @RequestBody TestDto input) {
        log.info("updateTest {}", input);

        return this.testService.updateTest(input);
    }
}
