package kg.megacom.miniTinder.services.MyCheckers;

import kg.megacom.miniTinder.models.Users;

public interface AutLogPassCheckServices {

    boolean checkMyLoginPass(Users users , String login, String password);
}
