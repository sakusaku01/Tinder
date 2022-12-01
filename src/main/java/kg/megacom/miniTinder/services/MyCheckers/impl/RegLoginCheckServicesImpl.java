package kg.megacom.miniTinder.services.MyCheckers.impl;

import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.services.MyCheckers.RegLoginCheckServices;

public class RegLoginCheckServicesImpl implements RegLoginCheckServices {

    @Override
    public boolean checkMyLogin(Users users, String login) {
        if(users.getLogin() ==null){
//            users.setLogin(login);
            return true;
        }else if(users.getLogin().equals(login)){

        }return false;
    }
}
