package com.example.postgrestest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group", schema = "public")
public class Group {
    @Id
    @Column(name = "group_id")
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;
}
