package cn.javabs.school.dao.impl;

import cn.javabs.school.dao.UserDao;
import cn.javabs.school.entity.User;
import cn.javabs.school.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    /**
     * 添加用户[对用户的密码进行了md5加密]
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        try {
            return qr.update("insert into user(name,username,password,sex,email,birthday,createTime) values(?,?,password(?),?,?,?,?)",
            user.getName(),
            user.getUsername(),
            user.getPassword(),
            user.getSex(),
            user.getEmail(),
            user.getBirthday(),
            user.getCreateTime()
            );
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public int removeUser(int id) {
        try {
            return qr.update("delete from  user  where id = ?",id);
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public int editUser(User user) {
        try {
            return qr.update("update user set name =?,username =?,password =?,sex =?,email =?,isable=?, birthday=?,createTime=? where id = ?",
                    user.getName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getSex(),
                    user.getEmail(),
                    user.getIsable(),
                    user.getBirthday(),
                    user.getCreateTime(),
                    user.getId()
            );
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return qr.query("select id,name,username,password,sex,CONCAT(LEFT(email,4),'*****',RIGHT(email,7))as email,isable,type,birthday,createTime from  user  ",new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            return qr.query("select * from  user where id = ?  ",new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public List<User> getUserByLikeName(String username) {
       try {
            String sql  = "select * from  user where 1 = 1 ";
            ArrayList<String> list = new ArrayList<>();
            if (username != null){
                sql +="and username like ? ";
                list.add("%"+username+"%");
            }
            Object[] params = list.toArray();
            return qr.query(sql,new BeanListHandler<User>(User.class),params);
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            return qr.query("select * from  user where username = ? and password = ? ",new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            throw  new  RuntimeException(e);
        }
    }
}
