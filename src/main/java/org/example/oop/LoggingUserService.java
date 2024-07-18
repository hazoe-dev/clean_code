package org.example.oop;

public class LoggingUserService extends UserService{
    public void createUser() {
        System.out.println("Logging created");
        super.createUser();
    }
}
