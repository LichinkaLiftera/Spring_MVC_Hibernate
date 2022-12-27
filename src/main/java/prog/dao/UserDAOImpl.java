package prog.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext // for EntityManager | for SessionFactory @ Autowired
    private EntityManager entityManager;


    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id) ;
    }

    @Override
    public void deleteUser(long id) {
        User findUser = readUser(id);
        entityManager.remove(findUser);
        entityManager.flush();
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("delete from User");
    }

}
