package com.imtoocai.diary.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private Integer password;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "email")
    private String email;

    @PrePersist
    private void onCreate() {
        createTime = new Timestamp(System.currentTimeMillis());
    }



}
