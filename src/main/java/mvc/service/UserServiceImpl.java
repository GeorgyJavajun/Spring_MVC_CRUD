package mvc.service;

import mvc.dao.UserDao;
import mvc.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao) { this.userDao = userDao; }


    @Transactional
    @Override
    public List<User> getAllUsers() { return userDao.getAllUsers(); }

    @Transactional
    @Override
    public void saveUser(User user) { userDao.saveUser(user); }

    @Transactional
    @Override
    public void deleteUser(Long id) { userDao.deleteUser(id); }

    @Transactional
    @Override
    public User getUserById(Long id) { return userDao.getUserById(id); }
}
