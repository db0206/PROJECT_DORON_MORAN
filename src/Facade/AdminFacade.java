package Facade;

import Beans.Company;
import Beans.Customer;
import Login.LoginManager;

import java.util.ArrayList;

public class AdminFacade extends ClientFacade{

    public AdminFacade() {
        System.out.println("Welcome Admin!");
    }

    @Override
    public boolean login(String email, String password) {
        return LoginManager.adminLogin(email, password);
    }

    public void addCompany(Company company){
        companiesDAO.addCompany(company);
    }

    public void updateCompany(Company company){
        companiesDAO.updateCompany(company);
    }

    public void deleteCompany (int companyID){
        companiesDAO.deleteCompany(companyID);
    }

    public ArrayList<Company> getAllCompanies(){
        return companiesDAO.getAllCompanies();
    }

    public Company getOneCompany (int companyID){
        return companiesDAO.getOneCompany(companyID);
    }

    public void addCustomer(Customer customer){
        customersDAO.addCustomer(customer);
    }

    public void updateCustomer (Customer customer){
        customersDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int customerID){
        customersDAO.deleteCustomer(customerID);
    }

    public ArrayList<Customer> getAllCustomers(){
        return customersDAO.getAllCustomers();
    }

    public Customer getOneCustomer(int customerID){
        return customersDAO.getOneCustomer(customerID);
    }
}
