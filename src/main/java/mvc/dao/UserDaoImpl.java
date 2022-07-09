package mvc.dao;

import mvc.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private final EntityManager em;
    public UserDaoImpl(@Qualifier("getEntityManager") EntityManager em) { this.em = em; }


    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) { em.merge(user); }

    @Override
    public void deleteUser(Long id) { em.remove(getUserById(id)); }

    @Override
    public User getUserById(Long id) { return em.find(User.class, id); }
}
