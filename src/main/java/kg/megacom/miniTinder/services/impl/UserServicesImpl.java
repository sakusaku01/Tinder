package kg.megacom.miniTinder.services.impl;

import kg.megacom.miniTinder.dao.impl.DbHelperImpl;
import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.models.enums.Gender;
import kg.megacom.miniTinder.services.MyCheckers.AutLogPassCheckServices;
import kg.megacom.miniTinder.services.MyCheckers.RegLoginCheckServices;
import kg.megacom.miniTinder.services.MyCheckers.impl.AutLogPassCheckServicesImpl;
import kg.megacom.miniTinder.services.MyCheckers.impl.RegLoginCheckServicesImpl;
import kg.megacom.miniTinder.services.UserServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServicesImpl implements UserServices {

    DbHelperImpl dbHelper = new DbHelperImpl();
    RegLoginCheckServices regLoginCheckServices = new RegLoginCheckServicesImpl();
    AutLogPassCheckServices autLogPassCheckServices =new AutLogPassCheckServicesImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Users users) {

        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "insert into tb_users(login,password,name,gender,info)values(?,?,?,?,?)")) {
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getLogin());
            preparedStatement.setString(3, users.getPassword());
            preparedStatement.setString(4, users.getGender().toString());
            preparedStatement.setString(5, users.getInfo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            throw new RuntimeException("User save error");
        }

    }

    @Override
    public Users findById(Long id) {

        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_users where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
                user.setName(resultSet.getString("name"));
                user.setInfo(resultSet.getString("info"));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException("User save error");
        }

    }

    @Override
    public List<Users> findALL() {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Users> user = new ArrayList<>();
            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getLong("id"));
                users.setLogin(resultSet.getString("login"));
                users.setPassword(resultSet.getString("password"));
                users.setGender(Gender.valueOf(resultSet.getString("gender")));
                users.setName(resultSet.getString("name"));
                users.setInfo(resultSet.getString("info"));

                user.add(users);
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException("User save error");
        }
    }

    @Override
    public boolean checkLogin(String login) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_users where login=?")) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
                user.setName(resultSet.getString("name"));
                user.setInfo(resultSet.getString("info"));
            }

            return regLoginCheckServices.checkMyLogin(user,login);

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            throw new RuntimeException("User save error");
        }

    }

    @Override
    public boolean checkLoginPass(String login, String password) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_users where login=? and password=?")) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users users = new Users();
            while (resultSet.next()) {
//                users.setId(resultSet.getLong("id"));
                users.setLogin(resultSet.getString("login"));
                users.setPassword(resultSet.getString("password"));
//                users.setGender(Gender.valueOf(resultSet.getString("gender")));
//                users.setName(resultSet.getString("name"));
//                users.setInfo(resultSet.getString("info"));

            }
            preparedStatement.close();

            return autLogPassCheckServices.checkMyLoginPass(users,login,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            throw new RuntimeException("User save error");
        }
    }


}




