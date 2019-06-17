package cn.javabs.school.dao;

import cn.javabs.school.entity.User;

import java.util.List;

public interface UserDao {

    int saveUser(User user);

    int removeUser(int id);

    int editUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    List<User>  getUserByLikeName(String username);

    User login(String username, String password);
}
