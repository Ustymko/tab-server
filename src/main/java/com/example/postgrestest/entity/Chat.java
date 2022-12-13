package com.example.postgrestest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat", schema = "public")
public class Chat implements Serializable {
    @Id
    @Column(name = "chat_id")
    private Integer id;
    @Column(name = "title", length = 50)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "admin_chat",
    joinColumns = {
            @JoinColumn(name = "chat_id", referencedColumnName = "chat_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    })
//    @JsonManagedReference
    private Set<Admin> admins;
}
