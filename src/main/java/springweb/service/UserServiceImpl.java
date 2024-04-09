package springweb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springweb.dao.UserDao;
import springweb.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
    @Transactional
    public void updateUser(Long id, User user) {
        userDao.updateUser(id,user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
