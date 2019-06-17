package cn.javabs.school.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DbcpUtils数据库连接池工具类设计
 * @author Mryang
 */
public class DbcpUtils {
    public static DataSource dataSource;

    static {
        try {
            String myFile = "dbcp.properties";
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream(myFile);
            Properties props = new Properties();
            props.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 获取数据源
     * @return
     */
    public static  DataSource getDataSource(){
        return  dataSource;
    }

    /**
     * 通过数据源获取连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
