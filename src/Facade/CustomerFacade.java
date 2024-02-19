package Facade;

import Beans.Category;
import Beans.Coupon;
import Beans.Customer;

import java.util.ArrayList;

public class CustomerFacade extends ClientFacade{

    private int customerID;

    public CustomerFacade(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    @Override
    public boolean login(String email, String password) {
        return customersDAO.isCustomerExists(email, password);
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
