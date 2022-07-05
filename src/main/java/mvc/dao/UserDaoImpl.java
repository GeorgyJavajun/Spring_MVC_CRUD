package mvc.dao;

import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(@Qualifier("getEntityManager") EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {

    }

    @Transactional
    @Override
    public void editUser(User user) {

    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return null;
    }
}
