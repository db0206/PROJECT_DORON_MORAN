package DataBase;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;
import DAO.CompaniesDAO;
import DAO.CompaniesDBDAO;
import DAO.CouponsDBDAO;
import DAO.CustomersDBDAO;
import Facade.CompanyFacade;

import java.time.LocalDate;

public class Tester {

    public static void main(String[] args) {

        DBManager.createDataBase();
        CompaniesDAO companiesDAO = new CompaniesDBDAO(ConnectionPool.getInstance());
        CompanyFacade companyFacade = new CompanyFacade(1);

        Company company = new Company("Doron's Company", "doronbrgr@yahoo.com", "maiden666");
        Company company2 = new Company("Avital's Company", "avitalbrgr@yahoo.com", "avi920berger");

        Customer customer = new Customer("Doron", "Berger", "doronbrgr@gmail.com", "MillieB0423");

        Coupon coupon = new Coupon(1, Category.MOVIES,"1+1","Get one ticket for free", LocalDate.now(),LocalDate.of(2024,6,24),10,20.0,"image");



        System.out.println(companyFacade.login("doronbrgr@yahoo.com", "maiden666"));

    }
}
