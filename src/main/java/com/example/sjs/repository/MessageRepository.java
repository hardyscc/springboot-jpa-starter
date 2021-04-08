package com.example.sjs.repository;

import com.example.sjs.entity.Message;
import com.example.sjs.entity.MessagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, MessagePk> {
}