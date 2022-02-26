package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.dao.UserDAO;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> showUsers() {
        return userDAO.showUsers();
    }

    @Transactional
    @Override
    public User showById(long id) {
        return userDAO.showById(id);
    }

    @Transactional
    @Override
    public void update(long id, User updateUser) {
        userDAO.update(id, updateUser);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }


    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
}
