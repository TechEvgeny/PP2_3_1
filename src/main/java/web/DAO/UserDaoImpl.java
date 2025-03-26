package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }

}
