package kg.megacom.miniTinder.services.impl;

import kg.megacom.miniTinder.models.Acount;
import kg.megacom.miniTinder.models.Orders;
import kg.megacom.miniTinder.services.OperationOrderServices;
import kg.megacom.miniTinder.services.OrderServices;
import kg.megacom.miniTinder.services.UserServices;

import java.util.Scanner;

public class OperationOrderServicesImpl implements OperationOrderServices {

    Scanner scanner =new Scanner(System.in);
//    OrderServices orderServices = new OrderServicesImpl();
    UserServices userServices = new UserServicesImpl();



//    public void send() {
//        Orders orders = new Orders();
//        System.out.println("Список пользователей");
//        System.out.println(userServices.findALL());
//        System.out.println("Ваш id?");
//        orders.setSenderId(userServices.findById(scanner.nextLong()));
//        System.out.println("Кому вы хотите отправить симпатию?");
//        orders.setRecipientId(userServices.findById(scanner.nextLong()));
//        System.out.println("Добавьте послание");
//        orders.setMessage(scanner.next());
//        System.out.println("Ваше совпадение is false");
//        orders.setMatch(false);
//
//        orderServices.save(orders);
//
//    }
//
//    public  void sendTo(){
//        Orders orders = new Orders();
//        System.out.println("Введите ваш id,чтобы Узнать ваших отправителей");
//        System.out.println(orderServices.myOrder(scanner.nextLong()));
//        System.out.println("Введите ваш id");
//        System.out.println("Введите id получателя");
//        orderServices.update(scanner.nextLong(), scanner.nextLong());
//        if(orderServices.update(scanner.nextLong(), scanner.nextLong())){
//            System.out.println("Вы пара");
//        }else System.out.println("К сожалению");
//
//    }



}
