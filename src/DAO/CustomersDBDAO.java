package DAO;

import Beans.Company;
import Beans.Customer;
import DataBase.ConnectionPool;
import DataBase.DBManager;
import DataBase.UserLists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomersDBDAO implements CustomersDAO{
//TODO: update all the methods to include UserLists
    private ConnectionPool connectionPool;
    private static ArrayList<Customer> customers = new ArrayList<>();

    public CustomersDBDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public boolean isCustomerExists(String email, String password) {
        boolean result = false;
        for (Customer customer:customers){
            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword())){
                result = true;
            }
        }
        return result;
    }

    @Override
    public void addCustomer(Customer customer) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DBManager.ADD_CUSTOMER);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.execute();
            UserLists.getAllCustomers().add(customer);
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE " + DBManager.DB
                            + ".`customers` SET `FIRST_NAME` = '"+customer.getFirstName()+"', " +
                            "`LAST_NAME` = '"+customer.getLastName()+"', " +
                            "`EMAIL` = '"+customer.getEmail()+"', " +
                            "`PASSWORD` = '"+customer.getPassword()+"' " +
                            "WHERE (`ID` = '"+customer.getId()+"')");
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public void deleteCustomer(int customerID) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM " + DBManager.DB
                            + ".`customers` WHERE (`ID` = '"+customerID+"')");
            preparedStatement.execute();
            removeCustomerFromList(customerID);
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    private void removeCustomerFromList(int customerID) {
        for (Customer customer:customers){
            if (customerID == customer.getId()){
                customers.remove(customer);
                break;
            }
        }
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public Customer getOneCustomer(int customerID) {
        Customer desiredCustomer = null;
        for (Customer customer : customers) {
            if (customerID == customer.getId()) {
                desiredCustomer = customer;
                break;
            }
        }
        return desiredCustomer;
    }
}
