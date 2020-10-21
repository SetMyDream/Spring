package spring.service;

import java.util.List;
import java.util.Optional;

import spring.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    Optional<User> getById(Long userId);
}
