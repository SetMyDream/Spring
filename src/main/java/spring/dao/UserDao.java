package spring.dao;

import java.util.List;
import spring.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
