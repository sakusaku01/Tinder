package kg.megacom.miniTinder.dao.impl;

import kg.megacom.miniTinder.dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {

    Connection connection = null;
    @Override
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tinder_db","postgres","epson1234");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement;
    }

    public void getClose() throws SQLException {
        connection.close();
    }
}
