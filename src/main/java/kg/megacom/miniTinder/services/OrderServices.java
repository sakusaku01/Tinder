package kg.megacom.miniTinder.services;

import kg.megacom.miniTinder.models.MyAcount;
import kg.megacom.miniTinder.models.Orders;
import kg.megacom.miniTinder.models.Users;

import java.util.List;

public interface OrderServices {
    void save(Orders orders);
    Orders findById(Long id);
    List<Orders> findALL();

    boolean update(MyAcount myAcount, Long id , Long id1);

    List<Orders> myOrder(Long id);
    void saveMatch(MyAcount myAcount,Long sid,Long rid1);

}
