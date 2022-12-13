package com.example.postgrestest.controller;

import com.example.postgrestest.entity.Chat;
import com.example.postgrestest.repository.AdminRepository;
import com.example.postgrestest.repository.ChatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin/chat")
public class AdminChatController {
    AdminRepository adminRepository;

    ChatRepository chatRepository;

    public AdminChatController(AdminRepository adminRepository, ChatRepository chatRepository){
        this.adminRepository = adminRepository;
        this.chatRepository = chatRepository;
    }

    @GetMapping
    public List<Chat> getAllChats(){
        return chatRepository.findAll();
    }

    @PostMapping
    public Chat saveChatWithAdmins(@RequestBody Chat chat){
        return chatRepository.save(chat);
    }

    @GetMapping
    @RequestMapping(value = "/get_chat/{id}")
    public Optional<Chat> getById(@PathVariable Integer id){
        return chatRepository.findById(id);
    }

}
