package com.example.sjs.controller;

import com.example.sjs.dto.TestDto;
import com.example.sjs.entity.Test;
import com.example.sjs.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
