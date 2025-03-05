/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myproject;

/**
 *
 * @author RAZER
 */
public class User {
    private String userId;
    private String email;

    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void updateEmail(String newEmail) { this.email = newEmail; }
}
