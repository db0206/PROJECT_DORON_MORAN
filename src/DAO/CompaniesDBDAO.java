package DAO;

import Beans.Company;
import DataBase.ConnectionPool;

import java.util.ArrayList;

public class CompaniesDBDAO implements CompaniesDAO {


    private ConnectionPool connectionPool;

    // Constructor that takes a Connection
    public CompaniesDBDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    // Implement methods from CompaniesDAO interface
        @Override
        public boolean isCompanyExists (String email, String password){
            return false;
        }

        @Override
        public void addCompany (Company company){

        }

        @Override
        public void updateCompany (Company company){

        }

        @Override
        public void deleteCompany (int companyID){

        }

        @Override
        public ArrayList<Company> getAllCompanies () {
            return null;
        }

        @Override
        public Company getOneCompany ( int companyID){
            return null;
        }

    }
