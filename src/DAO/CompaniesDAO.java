package DAO;

import Beans.Company;

import java.util.ArrayList;

public interface CompaniesDAO {


    public boolean isCompanyExists (String email, String password);

    public void addCompany (Company company);

    public void updateCompany (Company company);

    public void deleteCompany (int companyID);

    public ArrayList<Company> getAllCompanies();

    public Company getOneCompany (int companyID);


}
