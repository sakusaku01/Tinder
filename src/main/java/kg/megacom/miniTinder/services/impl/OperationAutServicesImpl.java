package kg.megacom.miniTinder.services.impl;

import kg.megacom.miniTinder.models.Acount;
import kg.megacom.miniTinder.models.MyAcount;
import kg.megacom.miniTinder.models.Orders;
import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.services.*;

import java.util.Scanner;

public class OperationAutServicesImpl implements OperationAutServices {
    Scanner scanner = new Scanner(System.in);

    OrderServices orderServices = null;

    OperationOrderServices operationOrderServices = new OperationOrderServicesImpl();
    UserServices userServices = new UserServicesImpl();

    MyAcount myAcount =new Acount();
    Orders orders = new Orders();


    @Override
    public String authorization() {
        while (true){
            orderServices = new OrderServicesImpl();
            System.out.println("Введите ваш логин: ");
            String login = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
            if(userServices.checkLoginPass(login,password)){
                myAcount.saveAccount(login,password);
               while (true){
                   System.out.println("1 отправить симпатию");
                   System.out.println("2 кто мне отправил симпатию");
                   System.out.println("3 выйти из аккаунта");
                   switch (scanner.nextInt()) {
                       case 1:
                           send();
                           break;
                       case 2:
                           sendTo();
                           break;
                       case 3:
                           logOut();
                           break;
                   }
               }

            }else {
                System.out.println("Пользователя с таким акаунтом не сущесвует");

            }
        }

    }


    public void send() {
        Orders orders = new Orders();
        System.out.println("Список пользователей");
        System.out.println(userServices.findALL());
        System.out.println("Ваш id?");
        orders.setSenderId(userServices.findById(scanner.nextLong()));
        System.out.println("Кому вы хотите отправить симпатию?");
        orders.setRecipientId(userServices.findById(scanner.nextLong()));
        System.out.println("Добавьте послание");
        orders.setMessage(scanner.next());
        System.out.println("Ваше совпадение is false");
        orders.setMatch(false);

        orderServices.save(orders);

    }

    public  void sendTo(){
        orderServices = new OrderServicesImpl();
        System.out.println("Введите ваш id,чтобы Узнать ваших отправителей");
        System.out.println(orderServices.myOrder(scanner.nextLong()));
        System.out.println(myAcount);
        System.out.println("Введите ваш id");
        Long sid = scanner.nextLong();
        System.out.println("Введите id получателя");
        Long rid1 = scanner.nextLong();
        if(!orderServices.update(myAcount,sid, rid1)){
            orderServices.saveMatch(myAcount,sid,rid1);
            System.out.println("Вы пара");
        }else System.out.println("К сожалению");

    }



    @Override
    public String logOut() {
        System.out.println("Нажмите 1 чтобы выйти из акканута");
        System.out.println("Нажмите 2 чтобы выйти в главное меню");
        switch (scanner.nextInt()){
            case 1:
                myAcount = null;
                System.out.println(myAcount);
                System.out.println("Вы вышли из аккаунта");
                System.out.println("-------------------");
                break;
            case 2:
                break;
        }
        return null;
    }


    @Override
    public boolean myMatchCheck(MyAcount myAcount,Orders orders, Long sid, Long rid1) {
        if(myAcount.getLogin().equals(orders.getRecipientId().getLogin()) && orders.getSenderId().equals(rid1)){
            orderServices.findById(sid).setMatch(true);
            return true;
        }else
//            orderServices.findById(sid).setMatch(false);
            return false;
    }

}

