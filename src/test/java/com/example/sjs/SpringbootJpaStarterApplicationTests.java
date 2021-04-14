package com.example.sjs;

import com.example.sjs.dto.TestDto;
import com.example.sjs.dto.TestPropDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootJpaStarterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void crudTest() {

        String code = "T01";
        String name = "Testing 01";
        String propName = "color";
        String propValue = "black";

        ResponseEntity<com.example.sjs.entity.Test> getResponse = this.restTemplate.getForEntity(
                "/test/" + code,
                com.example.sjs.entity.Test.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());


        ResponseEntity<com.example.sjs.entity.Test> postResponse = this.restTemplate.postForEntity(
                "/test",
                TestDto.builder()
                        .code(code)
                        .name(name)
                        .props(Collections.singletonList(
                                TestPropDto.builder().name(propName).value(propValue).build()
                        ))
                        .build(),
                com.example.sjs.entity.Test.class);

        Assertions.assertAll("Post Test : " + code,
                () -> Assertions.assertEquals(HttpStatus.OK, postResponse.getStatusCode()),
                () -> Assertions.assertNotNull(postResponse.getBody()),
                () -> Assertions.assertEquals(code, Objects.requireNonNull(postResponse.getBody()).getCode()),
                () -> Assertions.assertEquals(name, postResponse.getBody().getTestVerLatest().getName()),
                () -> Assertions.assertEquals(1, postResponse.getBody().getTestVerLatest().getVersion()),
                () -> Assertions.assertEquals(propName, postResponse.getBody().getTestVerLatest().getProps().get(0).getName()),
                () -> Assertions.assertEquals(propValue, postResponse.getBody().getTestVerLatest().getProps().get(0).getValue())
        );


        ResponseEntity<com.example.sjs.entity.Test> putResponse = this.restTemplate.exchange(
                "/test",
                HttpMethod.PUT,
                new HttpEntity<>(TestDto.builder()
                        .code(code)
                        .name(name + " v2")
                        .props(Collections.singletonList(
                                TestPropDto.builder().name(propName).value(propValue).build()
                        ))
                        .build()),
                com.example.sjs.entity.Test.class);

        Assertions.assertAll("Put Test : " + code,
                () -> Assertions.assertEquals(HttpStatus.OK, putResponse.getStatusCode()),
                () -> Assertions.assertNotNull(putResponse.getBody()),
                () -> Assertions.assertEquals(code, Objects.requireNonNull(putResponse.getBody()).getCode()),
                () -> Assertions.assertEquals(name + " v2", putResponse.getBody().getTestVerLatest().getName()),
                () -> Assertions.assertEquals(2, putResponse.getBody().getTestVerLatest().getVersion()),
                () -> Assertions.assertEquals(propName, putResponse.getBody().getTestVerLatest().getProps().get(0).getName()),
                () -> Assertions.assertEquals(propValue, putResponse.getBody().getTestVerLatest().getProps().get(0).getValue())
        );


        ResponseEntity<com.example.sjs.entity.Test> verifyResponse = this.restTemplate.getForEntity(
                "/test/" + code,
                com.example.sjs.entity.Test.class);

        Assertions.assertAll("Verify Test : " + code,
                () -> Assertions.assertEquals(HttpStatus.OK, verifyResponse.getStatusCode()),
                () -> Assertions.assertNotNull(verifyResponse.getBody()),
                () -> Assertions.assertEquals(code, Objects.requireNonNull(verifyResponse.getBody()).getCode()),
                () -> Assertions.assertEquals(name + " v2", verifyResponse.getBody().getTestVerLatest().getName()),
                () -> Assertions.assertEquals(2, verifyResponse.getBody().getTestVerLatest().getVersion()),
                () -> Assertions.assertEquals(propName, verifyResponse.getBody().getTestVerLatest().getProps().get(0).getName()),
                () -> Assertions.assertEquals(propValue, verifyResponse.getBody().getTestVerLatest().getProps().get(0).getValue())
        );
    }

}
