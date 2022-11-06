package com.myccb.utils.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 手动  原始方式  数据库连接池
 * @author 黄弋峰
 */
public class jdbcUtil {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    //1.属性资源导入
    static {
        try {
            InputStream in = jdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"); //获取输入流

            Properties properties = new Properties();  //创建空属性列表
            properties.load(in);  //加载流资源

            //获取属性资源
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //2.驱动只用加载一次
            Class.forName(driver);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    //3.获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //4.释放连接资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

