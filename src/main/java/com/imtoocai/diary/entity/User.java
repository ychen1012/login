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

    /*
    修改数据库格式 加盐加密
     */
    @Column(name = "password")
    private String password;

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
