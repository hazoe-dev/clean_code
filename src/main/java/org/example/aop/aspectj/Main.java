package org.example.aop.aspectj;

import org.example.proxy.UserService;
import org.example.proxy.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUser();
    }


}