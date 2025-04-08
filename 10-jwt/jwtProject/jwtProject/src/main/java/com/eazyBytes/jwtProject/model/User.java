package com.eazyBytes.jwtProject.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long Id;

    @Column
    private String username;

    @Column
    private String password;



    public User(long id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
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
        return "User [Id=" + Id + ", username=" + username + ", password=" + password + "]";
    }

    


}
