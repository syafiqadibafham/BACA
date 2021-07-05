package com.malaysianmannheim.baca.ui.database;

public class User {
    String name, username, password;
    int age;

    public User (String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }
}
