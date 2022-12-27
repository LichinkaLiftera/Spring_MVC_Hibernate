package prog.service;

import prog.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    void createUser(User user);
    @Transactional
    User readUser(long id);
    @Transactional
    void deleteUser(long id);
    @Transactional
    void updateUser(User user);
    @Transactional
    List<User> getAllUsers();

    @Transactional
    void deleteAll();

}
