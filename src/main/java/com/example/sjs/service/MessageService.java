package com.example.sjs.service;

import com.example.sjs.entity.Message;
import com.example.sjs.entity.MessagePk;
import com.example.sjs.exception.impl.NotFoundException;
import com.example.sjs.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message findById(String hospCode, String messageCode) {
        return this.messageRepository.findById(new MessagePk(hospCode, messageCode)).orElseThrow(
                () -> new NotFoundException(
                        String.format("Message %s:%s not found", hospCode, messageCode))
        );
    }
}
