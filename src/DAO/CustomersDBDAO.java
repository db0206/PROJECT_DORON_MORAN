package DAO;

import Beans.Customer;
import DataBase.ConnectionPool;

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
