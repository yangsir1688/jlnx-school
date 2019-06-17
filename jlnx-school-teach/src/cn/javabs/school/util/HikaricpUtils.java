package cn.javabs.school.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * HikaricpUtils数据库连接池工具类设计
 * @author Mryang
 */
public class HikaricpUtils {

    public static HikariDataSource dataSource;

    /**
     * 获取数据源
     * @return
     */
    public static  DataSource getDataSource(){

            try {
                String myFile = "hikaricp.properties";
                InputStream is = HikaricpUtils.class.getClassLoader().getResourceAsStream(myFile);
                Properties props = new Properties();
                props.load(is);
                HikariConfig hikariConfig = new HikariConfig(props);
                if (dataSource == null){
                    dataSource = new HikariDataSource(hikariConfig);
                }
                return dataSource;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * 通过数据源获取连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
