package Facade;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DataBase.UserLists;
import Login.LoginManager;

import java.util.ArrayList;

public class CustomerFacade extends ClientFacade{

    private int customerID;

    public CustomerFacade(int customerID) {
        System.out.println("Welcome Customer!");
        this.customerID = customerID;
    }

    public static int getIdThroughLogin(String email, String password) {
        int id = 0;
        for (Customer customer: UserLists.getAllCustomers()){
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                id = customer.getId();
            }
        }
        return id;
    }

    public int getCustomerID() {
        return customerID;
    }

    @Override
    public boolean login(String email, String password) {
        return LoginManager.customerLogin(email, password);
    }

    public void purchaseCoupon(Coupon coupon){

    }

    public ArrayList<Coupon> getCustomerCoupons(){
        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category){
        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(double maxPrice){
        return null;
    }

    public Customer getCustomerDetails(){
       return customersDAO.getOneCustomer(this.customerID);
    }
}
