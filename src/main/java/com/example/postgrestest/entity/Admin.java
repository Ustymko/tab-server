package com.example.postgrestest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "admin", schema = "public")
public class Admin implements Serializable {
    @Id
    @Column(name = "admin_id")
    private Long id;

    @ManyToMany(mappedBy = "admins", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Chat> chats;
}
