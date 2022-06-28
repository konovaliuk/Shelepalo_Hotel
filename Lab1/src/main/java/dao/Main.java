package dao;

import connection.ConnectionPool;
import dao.interfaces.IChargeDao;
import dao.interfaces.IOrderDao;
import dao.interfaces.IRoomDao;
import dao.interfaces.IUsersDao;
import entities.Charge;
import entities.Order;
import entities.Room;
import entities.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Main {
    public static void main(String arg[]){

        System.out.println("\n");
        testUserDao();

        System.out.println("\n");
        testRoomDao();

        System.out.println("\n");
        testOrderDao();

        System.out.println("\n");
        testChargeDao();
    }

    //------------------------------------start of UserDaoTesting---------------------------------------------------------

    private static void testUserDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------UserDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IUsersDao userDao = DaoFactory.createUserDao(conn);

            System.out.println("Find ALl---");
            printAll(userDao.findAll());

            System.out.println("Find by id---");
            System.out.println(userDao.findById(1).toString());

            System.out.println("save---");
            Users user1 = new Users( "aapas321word", "student", "aan312ame", "aasur312name");
            userDao.save(user1);


            System.out.println("update---");
            userDao.update(17, user1 );

            System.out.println("delete---");
            userDao.delete(28);
            printAll(userDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of UserDaoTesting---------------------------------------------------------

    //------------------------------------start of RoomDaoTesting---------------------------------------------------------

    private static void testRoomDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------RoomDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IRoomDao roomDao = DaoFactory.createRoomDao(conn);

            System.out.println("Find ALl---");
            printAll(roomDao.findAll());

            System.out.println("Find by id---");
            System.out.println(roomDao.findById(1).toString());

            System.out.println("save---");
            Room room1 = new Room("nice", "3", "aasur312name");
            roomDao.save(room1);


            System.out.println("update---");
            roomDao.update(2, room1 );

            System.out.println("delete---");
            roomDao.delete(8);
            printAll(roomDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of UserDaoTesting---------------------------------------------------------

    //------------------------------------start of OrderDaoTesting---------------------------------------------------------

    private static void testOrderDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------OrderDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IOrderDao orderDao = DaoFactory.createOrderDao(conn);

            System.out.println("Find ALl---");
            printAll(orderDao.findAll());

            System.out.println("Find by id---");
            System.out.println(orderDao.findById(1).toString());

            System.out.println("save---");
            Order order1 = new Order(1, "2 fevral", 3,"large");
            orderDao.save(order1);


            System.out.println("update---");
            orderDao.update(2, order1 );

            System.out.println("delete---");
            orderDao.delete(8);
            printAll(orderDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of OrderDaoTesting---------------------------------------------------------

    //------------------------------------start of ChargeDaoTesting---------------------------------------------------------

    private static void testChargeDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------ChargeDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IChargeDao chargeDao = DaoFactory.createChargeDao(conn);

            System.out.println("Find ALl---");
            printAll(chargeDao.findAll());

            System.out.println("Find by id---");
            System.out.println(chargeDao.findById(1).toString());

            System.out.println("save---");
            Charge charge1 = new Charge( 555, 2, 3);
            chargeDao.save(charge1);


            System.out.println("update---");
            chargeDao.update(17, charge1 );

            System.out.println("delete---");
            chargeDao.delete(28);
            printAll(chargeDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of ChargeDaoTesting---------------------------------------------------------

    private static void printAll(List resultList){
        resultList.forEach((result) -> {
            System.out.println(result.toString());
        });

    }
}
