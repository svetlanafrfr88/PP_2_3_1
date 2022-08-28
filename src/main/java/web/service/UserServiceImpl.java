package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Object getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);

    }

    @Override
    public void updateUser(@Valid User user) {
        userDao.updateUser(user);

    }
}
