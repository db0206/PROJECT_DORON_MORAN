package CLS;

import Beans.Category;
import Beans.Company;
import Beans.Coupon;
import Beans.Customer;

import java.time.LocalDate;

public class Tester {

    public static void main(String[] args) {

        Coupon coupon = new Coupon(1,2, ,"camera","buy the camera fifty percent off", LocalDate.now(), LocalDate.now(),10,20.99,"this image" );


        System.out.println("=================================");

        Company company1 = new Company(01, "MDK", "mdk@gmail.com", "MDK1234");
        System.out.println(company1);

        Coupon coupon1 = new Coupon(01,1, Category.NEW_GEAR,"SONY A7SIII",
                "Mirrorless camera",
                LocalDate.of(2024,1,1),
                LocalDate.of(2024,1,31),
                10,16_000.0,null);

        company1.addCoupon(coupon1);

        System.out.println("=================================");

        System.out.println(company1);

        Customer customer1 = new Customer(01,"Moran", "Ariel",
                "morandce@gmail.com", "1234" );
        System.out.println("=================================");
        customer1.addCoupon(coupon1);

        System.out.println(customer1);




    }
}
