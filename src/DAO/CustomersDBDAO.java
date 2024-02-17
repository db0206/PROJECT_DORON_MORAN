package DAO;

import Beans.Customer;
import DataBase.ConnectionPool;
import DataBase.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomersDBDAO implements CustomersDAO{

    private ConnectionPool connectionPool;

    public CustomersDBDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public boolean isCustomerExists(String email, String password) {
        return false;
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
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int customerID) {

    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getOneCustomer(int customerID) {
        return null;
    }
}
