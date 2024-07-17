package org.example.aop.aspectj;

public class UserServiceImpl implements UserService {
    @Override
    public void createUser() {
        System.out.println("User created");
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(1l);
        user.setName("username");
        return user;
    }
}

