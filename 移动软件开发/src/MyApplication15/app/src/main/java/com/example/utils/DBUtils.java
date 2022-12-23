package com.example.utils;

import com.example.entity.ContactEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    final String jdbc_address = "jdbc:mysql://119.28.10.179:3306/test9?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    final String jdbc_user = "root";
    final String jdbc_password = "zhuzhou9uu897@";
    final String driver = "com.mysql.jdbc.Driver";

    static DBUtils instance;

    public static DBUtils getInstance() {
        if (instance == null) {
            instance = new DBUtils();
        }
        return instance;
    }

    public List<ContactEntity> query(String sql) {
        try {
            Class.forName(driver).newInstance();

            Connection connection = DriverManager.getConnection(jdbc_address, jdbc_user, jdbc_password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<ContactEntity> list = new ArrayList<>();

            while (resultSet.next()) {
                ContactEntity contactEntity = new ContactEntity();
                contactEntity.setId(resultSet.getInt("id"));
                contactEntity.setName(resultSet.getString("name"));
                contactEntity.setSex(resultSet.getString("sex"));
                contactEntity.setBirthday(resultSet.getString("birthday"));
                contactEntity.setQq(resultSet.getString("qq"));
                contactEntity.setPhone(resultSet.getString("phone"));

                list.add(contactEntity);
            }

            resultSet.close();
            statement.close();
            connection.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int execute(String sql) {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbc_address, jdbc_user, jdbc_password);
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
