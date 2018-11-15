package com.imtoocai.diary.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    private Long password;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Email(message = "请输入正确的邮箱")
    @Column(name = "email")
    private String email;

    @PrePersist
    private void onCreate() {
        createTime = new Timestamp(System.currentTimeMillis());
    }


}
