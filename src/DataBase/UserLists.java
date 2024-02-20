package DataBase;

import Beans.Company;
import Beans.Customer;

import java.util.ArrayList;

public class UserLists {

    private static ArrayList<Company> allCompanies = new ArrayList<>();
    private static ArrayList<Customer> allCustomers = new ArrayList<>();

    public static ArrayList<Company> getAllCompanies() {
        return allCompanies;
    }

    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
}
