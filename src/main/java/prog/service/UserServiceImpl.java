package prog.service;

import prog.dao.UserDAO;
import prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Transactional
    @Override
    public User readUser(long id){
        return userDAO.readUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteAll(){
        userDAO.deleteAll();
    }
}
