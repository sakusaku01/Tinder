package kg.megacom.miniTinder.services.MyCheckers;

import kg.megacom.miniTinder.models.MyAcount;
import kg.megacom.miniTinder.models.Orders;
import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.services.OrderServices;
import kg.megacom.miniTinder.services.impl.OrderServicesImpl;

public interface MatchCheckServices {

    boolean myMatchCheck(MyAcount myAcount,Orders orders, Long id, Long id1);

}
