package DataBase;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DAO.CompaniesDBDAO;
import DAO.CouponsDBDAO;
import DAO.CustomersDBDAO;

import java.time.LocalDate;

public class Tester {

    public static void main(String[] args) {

        DBManager.createDataBase();

        CompaniesDBDAO companiesDBDAO = new CompaniesDBDAO(ConnectionPool.getInstance());
        CustomersDBDAO customersDBDAO = new CustomersDBDAO(ConnectionPool.getInstance());
        CouponsDBDAO couponsDBDAO = new CouponsDBDAO(ConnectionPool.getInstance());

        Company company = new Company("Doron's Company", "doronbrgr@yahoo.com", "maiden666");
        Company company2 = new Company("Avital's Company", "avitalbrgr@yahoo.com", "avi920berger");

        Customer customer = new Customer("Doron", "Berger", "doronbrgr@gmail.com", "MillieB0423");

        Coupon coupon = new Coupon(1, Category.MOVIES,"1+1","Get one ticket for free", LocalDate.now(),LocalDate.of(2024,6,24),10,20.0,"image");
/*
        companiesDBDAO.addCompany(company);
        companiesDBDAO.addCompany(company2);
        customersDBDAO.addCustomer(customer);
        couponsDBDAO.addCoupon(coupon);
        */
        company.setEmail("b??");
        company.setPassword("blahblah millie blah");

        company2.setEmail("bbbbb");

        customer.setEmail("sfsdf");
        customer.setFirstName("Adam");

        coupon.setAmount(100);

        companiesDBDAO.updateCompany(company);
        customersDBDAO.updateCustomer(customer);
        couponsDBDAO.updateCoupon(coupon);


    }
}
