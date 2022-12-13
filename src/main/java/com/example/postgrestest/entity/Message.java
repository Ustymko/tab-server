package com.example.postgrestest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message", schema = "public")
public class Message {

  @Id
  @Column(name = "message_id")
  private Integer id;

  @Column(name = "message_body")
  private String messageBody;

  @Column(name = "is_ad")
  private Boolean isAdvertisement;

  @Column(name = "send_date")
  private Timestamp sendDate;

  @ManyToOne
  @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
  private Group group;

  @ManyToOne
  @JoinColumn(name = "sender_id", referencedColumnName = "user_id", nullable = false)
  private User user;


}
