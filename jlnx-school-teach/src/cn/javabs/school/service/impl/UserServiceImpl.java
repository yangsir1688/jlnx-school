package cn.javabs.school.service.impl;

import cn.javabs.school.dao.UserDao;
import cn.javabs.school.dao.impl.UserDaoImpl;
import cn.javabs.school.entity.User;
import cn.javabs.school.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userDao.saveUser(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int delUser(int id) {
        return userDao.removeUser(id);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userDao.editUser(user);
    }

    /**
     * 查询所有用户
     *
     * @return list
     */
    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    @Override
    public List<User>  findUserByLikeName(String username) {
        return userDao.getUserByLikeName(username);
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User userLogin(String username, String password) {
        return userDao.login(username,password);
    }
}
