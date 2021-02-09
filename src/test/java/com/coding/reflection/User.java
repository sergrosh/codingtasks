package com.coding.reflection;

@CustomAnnotation
public class User {
    private String userName;
    private String email;
    private String password;

    private User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    private void printUserData(String prefix) {
        System.out.println("User data: " + userName + " " + email + " " + password + " prefix: " + prefix);
    }
}
