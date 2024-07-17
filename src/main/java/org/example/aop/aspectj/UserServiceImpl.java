package org.example.aop.aspectj;

public class UserServiceImpl implements UserService {
    @Override
    public void createUser() {
        System.out.println("User created");
    }
}

