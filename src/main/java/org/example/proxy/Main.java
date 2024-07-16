package org.example.proxy;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Create a proxy for the UserService
        UserService proxy = LoggingProxy.createProxy(userService, UserService.class);

        // Call the method on the proxy
        proxy.createUser();
    }
}

