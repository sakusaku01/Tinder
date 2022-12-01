package kg.megacom.miniTinder.services;

import kg.megacom.miniTinder.models.MyAcount;
import kg.megacom.miniTinder.models.Orders;

public interface OperationAutServices {

    String authorization();
    String logOut();
     boolean myMatchCheck(MyAcount myAcount,Orders orders, Long id, Long id1);
}
