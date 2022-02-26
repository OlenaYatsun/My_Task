package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    List<User> showUsers();

    User showById(long id);

    void saveUser(User user);

    void update(long id, User updateUser);

    void delete(Long id);
}
