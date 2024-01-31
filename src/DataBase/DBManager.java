package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {
    // connection to mysql

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String SQL_USER = "root";
    public static final String SQL_PASS = "12345678";

    //DataBase
    public static final String DB = "project_doron_moran";

    public static final String CREATE_SCHEMA = "CREATE SCHEMA `project_moran_doron` ;";
    public static final String CREATE_TABLE_COMPANIES = "CREATE TABLE IF NOT EXISTS `project_doron_moran`.`companies` (" +
            " `ID` INT NOT NULL AUTO_INCREMENT," +
            " `NAME` VARCHAR(45) NOT NULL," +
            " `EMAIL` VARCHAR(45) NOT NULL," +
            " `PASSWORD` VARCHAR(45) NOT NULL," +
            " PRIMARY KEY (`ID`)," +
            " UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE," +
            " UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC) VISIBLE);";

    //CRUD

    public static void createSchema(){
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SCHEMA);
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());;
        }finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    public static void createTable(){
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_COMPANIES);
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());;
        }finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }
}
