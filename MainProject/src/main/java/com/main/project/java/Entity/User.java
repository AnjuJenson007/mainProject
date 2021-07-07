package com.main.project.java.Entity;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_phone")
    private long userPhoneNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber=" + userPhoneNumber +

                '}';
    }

    public User(int userId, String userName, String email, String userPassword, long userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;

    }
    public User(int userId) {
    }

    public User() {

    }
}
