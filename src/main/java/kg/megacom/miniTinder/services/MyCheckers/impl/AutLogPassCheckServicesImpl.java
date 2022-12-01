package kg.megacom.miniTinder.services.MyCheckers.impl;

import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.services.MyCheckers.AutLogPassCheckServices;

public class AutLogPassCheckServicesImpl implements AutLogPassCheckServices {



    @Override
    public boolean checkMyLoginPass(Users users,String login, String password) {
        if(users.getLogin()==null & users.getPassword()==null){
            return false;
        } else if (users.getLogin().equals(login) & users.getPassword().equals(password)) {

        }  return true;
    }



}
