package cn.javabs.school.test;

import cn.javabs.school.entity.User;
import cn.javabs.school.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * 基于单元测试Junit
 * 分别对三种数据库连接池进行测试
 */
public class TestData {

    /**
     * 1. 测试DruidUtils
     * 亲测无误
     * @throws SQLException
     */
    @Test
    public  void testDruidUtils() throws SQLException {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<User> users = runner.query("select * from user", new BeanListHandler<User>(User.class));
        System.out.println("users:"+users);
    }

    /**
     * 2. 测试DbcpUtils
     * 亲测无误
     * @throws SQLException
     */
    @Test
    public  void testDbcpUtils() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<User> list = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
        System.out.println("list:"+list);
    }
    /**
     * 3. 测试Hikaricptils
     * 亲测无误
     * @throws SQLException
     */
    @Test
    public  void testHikaricpUtils() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        List<User> userList = qr.query("select * from user", new BeanListHandler<User>(User.class));
        System.out.println("userList:"+userList);
    }


}
