package com.example.sjs.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.sjs.entity.Message;
import com.example.sjs.entity.MessagePk;
import com.example.sjs.exception.impl.NotFoundException;
import com.example.sjs.repository.MessageRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message findById(String hospCode, String messageCode) {
        return this.messageRepository.findById(new MessagePk(hospCode, messageCode)).orElseThrow(
                () -> new NotFoundException(
                        String.format("Message %s:%s not found", hospCode, messageCode)));
    }

    public List<Message> findAll() {
        return this.messageRepository.findAll();
    }
}
