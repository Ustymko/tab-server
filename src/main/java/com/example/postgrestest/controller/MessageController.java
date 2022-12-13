package com.example.postgrestest.controller;

import com.example.postgrestest.entity.Message;
import com.example.postgrestest.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(path = "/messages")
public class MessageController {

    MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public List<Message> findMessages() {
        return messageRepository.findAll();

    }

    @PostMapping
    @RequestMapping(value = "/post")
    public void saveMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }

    @GetMapping
    @RequestMapping(value = "/get/{id}")
    public Optional<Message> getById(@PathVariable Integer id) {
        return messageRepository.findById(id);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        messageRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "/put/{id}")
    public void update(@PathVariable Integer id, @RequestBody Message message){
        Message newMessage = messageRepository.getById(id);
        newMessage.setMessageBody(message.getMessageBody());
        newMessage.setUser(message.getUser());
        newMessage.setGroup(message.getGroup());
        newMessage.setSendDate(message.getSendDate());
        newMessage.setIsAdvertisement(message.getIsAdvertisement());
        messageRepository.save(newMessage);
    }
}
