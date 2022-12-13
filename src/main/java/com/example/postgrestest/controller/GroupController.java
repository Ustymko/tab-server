package com.example.postgrestest.controller;

import com.example.postgrestest.entity.Group;
import com.example.postgrestest.repository.GroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping(value = "groups")
public class GroupController {
    GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    @PostMapping
    @RequestMapping(value = "/post")
    public Group save(@RequestBody Group group){
        return groupRepository.save(group);
    }

    @GetMapping
    @RequestMapping(value = "/get/{id}")
    public Optional<Group> getById(@PathVariable Integer id){
        return groupRepository.findById(id);
    }

    @PutMapping
    @RequestMapping(value = "/put/{id}")
    public void update(@PathVariable Integer id, @RequestBody Group group){
        Group newGroup = groupRepository.getById(id);
        newGroup.setName(group.getName());
        groupRepository.save(newGroup);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        groupRepository.deleteById(id);
    }
}
