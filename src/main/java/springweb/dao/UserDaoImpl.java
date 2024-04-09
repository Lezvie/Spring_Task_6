package springweb.dao;

import org.springframework.stereotype.Repository;
import springweb.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User user where user.id = :id").setParameter("id",id).executeUpdate();
    }

    public void updateUser(Long id, User user) {
        User user1 = getUserById(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        entityManager.merge(user1);
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
