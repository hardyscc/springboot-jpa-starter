package com.example.sjs.controller;

import java.util.List;

import com.example.sjs.entity.Message;
import com.example.sjs.service.MessageService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @Operation(tags = "Message")
    @GetMapping(path = "/message/{hospCode}/{messageCode}")
    public Message getMessage(
            @PathVariable String hospCode,
            @PathVariable String messageCode) {
        log.info("getMessage {} {} ", hospCode, messageCode);
        return this.messageService.findById(hospCode, messageCode);
    }

    @Operation(tags = "Message")
    @GetMapping(path = "/message")
    public List<Message> getMessages() {
        log.info("getMessages");
        return this.messageService.findAll();
    }
}