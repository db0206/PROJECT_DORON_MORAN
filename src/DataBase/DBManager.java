package DataBase;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {
    // connection to mysql

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String SQL_USER = "root";
    public static final String SQL_PASS = "12345678";

    //DataBase
    public static final String DB = "anything_we_want";

    public static final String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS `" + DB + "` ;";
    public static final String CREATE_TABLE_COMPANIES = "CREATE TABLE IF NOT EXISTS `" + DB + "`.`companies` (" +
            " `ID` INT NOT NULL AUTO_INCREMENT," +
            " `NAME` VARCHAR(45) NOT NULL," +
            " `EMAIL` VARCHAR(45) NOT NULL," +
            " `PASSWORD` VARCHAR(45) NOT NULL," +
            " PRIMARY KEY (`ID`)," +
            " UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE," +
            " UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC) VISIBLE);";

    public static final String CREATE_TABLE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS `" + DB + "`.`customers` (" +
            " `ID` INT NOT NULL AUTO_INCREMENT," +
            " `NAME` VARCHAR(45) NOT NULL," +
            " `EMAIL` VARCHAR(45) NOT NULL," +
            " `PASSWORD` VARCHAR(45) NOT NULL," +
            " PRIMARY KEY (`ID`)," +
            " UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE);";

    public static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE IF NOT EXISTS `" + DB + "`.`categories` (" +
            " `ID` INT NOT NULL AUTO_INCREMENT," +
            " `NAME` VARCHAR(45) NOT NULL," +
            " PRIMARY KEY (`ID`)," +
            " UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC) VISIBLE);";

    public static final String CREATE_TABLE_COUPONS = "CREATE TABLE IF NOT EXISTS `" + DB + "`.`coupons` (" +
            " `ID` INT NOT NULL AUTO_INCREMENT," +
            " `COMPANY_ID` INT NOT NULL," +
            " `CATEGORY_ID` INT NOT NULL," +
            " `TITLE` VARCHAR(45) NOT NULL," +
            " `DESCRIPTION` VARCHAR(45) NOT NULL," +
            " `START_DATE` DATE NOT NULL," +
            " `END_DATE` DATE NOT NULL," +
            " `AMOUNT` INT NULL," +
            " `PRICE` DECIMAL NOT NULL," +
            " `IMAGE` VARCHAR(45) NOT NULL," +
            " PRIMARY KEY (`ID`)," +
            " UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)";

    public static final String CREATE_TABLE_CUSTOMERS_VS_COUPONS = "CREATE TABLE IF NOT EXISTS `"+DB+"`.`customers_vs_coupons` (" +
            " `CUSTOMER_ID` INT NOT NULL," +
            " `COUPON_ID` INT NOT NULL," +
            " PRIMARY KEY (`CUSTOMER_ID`, `COUPON_ID`))";

    //CRUD

    public static void createDataBase(){
        createSchema();
        createTable(DBManager.CREATE_TABLE_COMPANIES);
        createTable(DBManager.CREATE_TABLE_CATEGORIES);
        createTable(DBManager.CREATE_TABLE_CUSTOMERS);
        createTable(DBManager.CREATE_TABLE_COUPONS);
        createTable(DBManager.CREATE_TABLE_CUSTOMERS_VS_COUPONS);
    }
    public static void createSchema() {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SCHEMA);
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            ;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    public static void createTable(String str) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(str);
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            ;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }
}
