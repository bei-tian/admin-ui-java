package com.beitian.adminuijava.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "用户名不能为空")
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 5, message = "密码不能小于5位")
    private String password;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private Timestamp createTime;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
