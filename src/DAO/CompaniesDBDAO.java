package DAO;

import Beans.Company;
import DataBase.ConnectionPool;
import DataBase.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            Connection connection = null;

            try {
                connection = connectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DBManager.ADD_COMPANY);
                preparedStatement.setString(1, company.getName());
                preparedStatement.setString(2, company.getEmail());
                preparedStatement.setString(3, company.getPassword());
                preparedStatement.execute();
            } catch (InterruptedException | SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connectionPool.restoreConnection(connection);
            }

        }

        @Override
        public void updateCompany (Company company){
            Connection connection = null;

            try {
                connection = connectionPool.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement("UPDATE " + DBManager.DB
                                + ".`companies` SET `EMAIL` = '"+company.getEmail()+"', " +
                                "`PASSWORD` = '"+company.getPassword()+"' " +
                                "WHERE (`ID` = '"+company.getId()+"')");
                preparedStatement.execute();
            } catch (InterruptedException | SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connectionPool.restoreConnection(connection);
            }
        }

        @Override
        public void deleteCompany (int companyID){
            Connection connection = null;

            try {
                connection = connectionPool.getConnection();
                PreparedStatement preparedStatement =
                       connection.prepareStatement("DELETE FROM " + DBManager.DB
                                + ".`companies` WHERE (`ID` = '"+companyID+"')");
                preparedStatement.execute();
            } catch (InterruptedException | SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connectionPool.restoreConnection(connection);
            }
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
