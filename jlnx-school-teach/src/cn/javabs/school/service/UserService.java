package cn.javabs.school.service;

import cn.javabs.school.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delUser(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有用户
     * @return list
     */
    List<User> findAllUsers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    List<User>  findUserByLikeName(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User userLogin(String username, String password);

}
