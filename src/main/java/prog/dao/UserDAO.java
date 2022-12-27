package prog.dao;

import prog.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    User readUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
    void deleteAll();
}
