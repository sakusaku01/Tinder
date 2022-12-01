package kg.megacom.miniTinder.services.impl;

import kg.megacom.miniTinder.dao.impl.DbHelperImpl;
import kg.megacom.miniTinder.models.Acount;
import kg.megacom.miniTinder.models.MyAcount;
import kg.megacom.miniTinder.models.Orders;
import kg.megacom.miniTinder.models.Users;
import kg.megacom.miniTinder.services.MyCheckers.MatchCheckServices;
import kg.megacom.miniTinder.services.MyCheckers.impl.MatchCheckServicesImpl;
import kg.megacom.miniTinder.services.OperationAutServices;
import kg.megacom.miniTinder.services.OrderServices;
import kg.megacom.miniTinder.services.UserServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServicesImpl implements OrderServices {

    DbHelperImpl dbHelper = new DbHelperImpl();

    UserServices userServices=new UserServicesImpl();


    OperationAutServices operationAutServices = new OperationAutServicesImpl();

    Users users = new Users();
    Orders orders = new Orders();

    MyAcount myAcount = new Acount();


    @Override
    public void save(Orders orders) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "insert into tb_order(sender_id,recipient_id,message,match)values(?,?,?,?)")){
            preparedStatement.setLong(1,orders.getSenderId().getId());
            preparedStatement.setLong(2,orders.getRecipientId().getId());
            preparedStatement.setString(3,orders.getMessage());
            preparedStatement.setBoolean(4, orders.getMatch());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("User save error");
        }
    }

    @Override
    public Orders findById(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_order where id=?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Orders orders = null;
            while(resultSet.next()){
                orders.setId(resultSet.getLong("id"));
                orders.setSenderId(userServices.findById(resultSet.getLong("sender_id")));
                orders.setRecipientId(userServices.findById(resultSet.getLong("recipient_id")));
                orders.setMessage(resultSet.getString("message"));
                orders.setMatch(resultSet.getBoolean("match"));

            }
            return orders;

        } catch (SQLException e) {
            throw new RuntimeException("User save error");
        }
    }

    @Override
    public List<Orders> findALL() {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_order")){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> order = new ArrayList<>();
            while(resultSet.next()){
                Orders orders =new Orders();
                orders.setId(resultSet.getLong("id"));
                orders.setSenderId(userServices.findById(resultSet.getLong("sender_id")));
                orders.setRecipientId(userServices.findById(resultSet.getLong("recipient_id")));
                orders.setMessage(resultSet.getString("message"));
                orders.setMatch(resultSet.getBoolean("match"));
                order.add(orders);
            }
            return order;

        } catch (SQLException e) {
            throw new RuntimeException("User save error");
        }
    }



    @Override
    public List<Orders> myOrder(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_order where recipient_id=?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> order = new ArrayList<>();
            while(resultSet.next()){
                Orders orders =new Orders();
                orders.setId(resultSet.getLong("id"));
                orders.setSenderId(userServices.findById(resultSet.getLong("sender_id")));
                orders.setRecipientId(userServices.findById(resultSet.getLong("recipient_id")));
                orders.setMessage(resultSet.getString("message"));
                orders.setMatch(resultSet.getBoolean("match"));
                order.add(orders);
            }
            return order;

        } catch (SQLException e) {
            throw new RuntimeException("Order id not found");
        }
    }

    @Override
    public boolean update(MyAcount myAcount,Long sid,Long rid1) {
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "select * from tb_order where sender_id=? and recipient_id=? ")){
            preparedStatement.setLong(1,rid1);
            preparedStatement.setLong(2,sid);
            ResultSet resultSet = preparedStatement.executeQuery();
            Orders orders = new Orders();
            while(resultSet.next()){
//                orders.setId(resultSet.getLong("id"));
                orders.setSenderId(userServices.findById(resultSet.getLong("sender_id")));
                orders.setRecipientId(userServices.findById(resultSet.getLong("recipient_id")));
//                orders.setMessage(resultSet.getString("message"));
                orders.setMatch(resultSet.getBoolean("match"));


            }
            preparedStatement.close();
            return operationAutServices.myMatchCheck(myAcount,orders,sid,rid1);



        } catch (SQLException e) {
            throw new RuntimeException(e);
//            throw new RuntimeException("User save error");
        }
    }
    public void saveMatch(MyAcount myAcount,Long sid,Long rid1){
        try (PreparedStatement preparedStatement = dbHelper.getPreparedStatement(
                "update tb_order set match =? where sender_id=? and recipient_id=?")){
            preparedStatement.setBoolean(1,true);
            preparedStatement.setLong(2,rid1);
            preparedStatement.setLong(3,sid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            throw new RuntimeException("Match save error");
        }
    }

}
