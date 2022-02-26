package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User showById(long id) {
        TypedQuery<User> a = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class
        );
        a.setParameter("id", id);
        return a.getResultList().stream().findAny().orElse(null);
    }


    @Override
    public void update(long id, User updateUser) {
        entityManager.merge(updateUser);
    }


    @Override
    public void delete(Long id) {
        entityManager.remove(showById(id));
    }


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
}
