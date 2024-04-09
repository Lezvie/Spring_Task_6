package springweb.dao;

import springweb.model.User;

import javax.persistence.Id;
import java.util.List;

public interface UserDao {
    void createUser(User user);
    void deleteUser(Long id);

    void updateUser(Long id, User user);
    User getUserById(Long id);

    List<User> getAllUsers();
}