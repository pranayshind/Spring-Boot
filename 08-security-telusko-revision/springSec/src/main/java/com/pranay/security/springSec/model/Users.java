package com.pranay.security.springSec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class Users {
    @Id
    private int Id;
    private String username;
    private String password;
    public Users(int id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Users [Id=" + Id + ", username=" + username + ", password=" + password + "]";
    }





}
