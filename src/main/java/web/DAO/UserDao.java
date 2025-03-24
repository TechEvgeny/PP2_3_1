package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    User getUserById(int id);

    void deleteUser(int id);

    void updateUser(int id, User user);
}
