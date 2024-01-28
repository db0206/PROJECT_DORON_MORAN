package CLS;

import Beans.Category;
import Beans.Coupon;

import java.time.LocalDate;

public class Tester {

    public static void main(String[] args) {

        Coupon coupon = new Coupon(1,2, ,"camera","buy the camera fifty percent off", LocalDate.now(), LocalDate.now(),10,20.99,"this image" );
    }
}
