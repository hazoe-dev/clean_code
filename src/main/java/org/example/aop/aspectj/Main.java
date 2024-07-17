package org.example.aop.aspectj;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUser();
        userService.getUserById(1);

    }


}