package org.example.oop;

public class Main {
    public static void main(String[] args) {
        LoggingUserService userService = new LoggingUserService();
        userService.createUser();
    }
}
