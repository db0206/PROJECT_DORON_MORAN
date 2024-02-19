package Facade;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;

import java.util.ArrayList;

public class CompanyFacade extends ClientFacade{

    private int companyID;

    public CompanyFacade(int companyID) {
        super();
        this.companyID = companyID;
    }

    public int getCompanyID() {
        return companyID;
    }

    @Override
    public boolean login(String email, String password) {
        return companiesDAO.isCompanyExists(email, password);
    }

    public void addCoupon(Coupon coupon){
        couponsDAO.addCoupon(coupon);
    }

    public void updateCoupon (Coupon coupon){
        couponsDAO.updateCoupon(coupon);
    }

    public void deleteCoupon (int couponID){
        couponsDAO.deleteCoupon(couponID);
    }

    public ArrayList<Coupon> getCompanyCoupons(){
        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category){
        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice){
        return null;
    }

    public Company getCompanyDetails(){
        return companiesDAO.getOneCompany(this.companyID);
    }
}
