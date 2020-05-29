package com.spring.security.social.login.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("user")
public class User {
    
    @PrimaryKey("userId")
    private String userId;     
      
    @Column("name")
    private String name;

    @Column("password")
    private String password;

    @Column("email_id")
    private String emailId;

    @Column("active")
    private Integer active;

    @Column("provider")
    private String provider;

    public User() {
    }

    public User(final String userId, final String name, final String password, final String emailId, final Integer active, final String provider) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.emailId = emailId;
        this.active = active;
        this.provider = provider;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(final String provider) {
        this.provider = provider;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }
}

