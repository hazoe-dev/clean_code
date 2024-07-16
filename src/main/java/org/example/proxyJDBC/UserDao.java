package org.example.proxyJDBC;

public interface UserDao {
    void save(User user);
    User findById(Long id);
}
