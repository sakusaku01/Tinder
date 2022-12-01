package kg.megacom.miniTinder.services;

import kg.megacom.miniTinder.models.Users;

import java.util.List;

public interface UserServices {
    void save(Users users);
    Users findById(Long id);
    List<Users> findALL();

    boolean checkLogin(String login);
    boolean checkLoginPass(String login, String password);
}
