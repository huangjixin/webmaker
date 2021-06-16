package com.hjx.webmaker.modules.art.service.impl;

import com.hjx.webmaker.CoreApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DatasourceTest {

    public static void main(String[] args) {
        String mysqlDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    String mysqlDriver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test1";
    String newUrl = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "root";
    Connection conn = null;
    Connection newConn = null;

    public Connection getConn(String database) {

        try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String tableSql = "create table t_user (username varchar(50) not null primary key,"
                    + "password varchar(20) not null ); ";
            String databaseSql = "create database " + database;

            conn = DriverManager.getConnection(url, username, password);
            Statement smt = conn.createStatement();
            if (conn != null) {
                System.out.println("数据库连接成功！");

                smt.executeUpdate(databaseSql);

                newConn = DriverManager.getConnection(newUrl + database,
                        username, password);
                if (newConn != null) {
                    System.out.println("已经连接到新创建的数据库：" + database);

                    Statement newSmt = newConn.createStatement();
                    int i = newSmt.executeUpdate(tableSql);//DDL语句返回值为0;
                    if (i == 0) {
                        System.out.println(tableSql + "表已经创建成功！");
                    }
                }
            }

        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        return conn;
    }
}
