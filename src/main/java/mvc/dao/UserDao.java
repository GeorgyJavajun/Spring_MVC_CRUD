package mvc.dao;

import mvc.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);
}
