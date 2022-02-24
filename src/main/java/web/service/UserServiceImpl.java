package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.dao.UserDAO;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Qualifier("userDAOImpl")
    @Autowired
    private UserDAO userDAO;



    @Override
    public List<User> showUsers() {
        return userDAO.showUsers();
    }

    @Override
    public User showById(long id) {
        return userDAO.showById(id);
    }


    @Override
    public void update(long id, User updateUser) {
        userDAO.update(id, updateUser);
    }



    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }



    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
}
