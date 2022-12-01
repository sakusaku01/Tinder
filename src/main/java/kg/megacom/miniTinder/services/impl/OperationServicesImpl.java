package kg.megacom.miniTinder.services.impl;

import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.models.enums.Gender;
import kg.megacom.miniTinder.services.OperationServices;
import kg.megacom.miniTinder.services.UserServices;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class OperationServicesImpl implements OperationServices {

    Scanner scanner = new Scanner(System.in);
    UserServices userServices = new UserServicesImpl();



    @Override
    public String registration() {
       Users users = new Users();

        while (true){
            System.out.println("Введите ваш логин: ");
            if(userServices.checkLogin(scanner.nextLine())){
                users.setLogin(scanner.next());
                System.out.println("Введите пароль: ");
                users.setPassword(scanner.next());
                System.out.println("Введите имя: ");
                users.setName(scanner.next());
                System.out.println("Введите пол: ");
                System.out.println(Arrays.asList(Gender.values()));
                users.setGender((Gender.valueOf(scanner.next())));
                System.out.println("Введите инфо: ");
                users.setInfo(scanner.next());
                System.out.println("Успешная регистрация");
                userServices.save(users);


            }else
                System.out.println("Такой логин уже существует,\nНапишите логин повторно");


        }

    }




}
