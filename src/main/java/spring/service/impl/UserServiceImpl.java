package spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.model.User;
import spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
