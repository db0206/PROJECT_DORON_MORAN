package DAO;

import Beans.Coupon;
import DataBase.ConnectionPool;
import DataBase.DBManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CouponsDBDAO implements CouponsDAO{

    private ConnectionPool connectionPool;

    public CouponsDBDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addCoupon(Coupon coupon) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DBManager.ADD_COUPON);
            preparedStatement.setInt(1, coupon.getCompanyID());
            preparedStatement.setInt(2, coupon.getCategory().getId());
            preparedStatement.setString(3, coupon.getTitle());
            preparedStatement.setString(4, coupon.getDescription());
            preparedStatement.setDate(5, Date.valueOf(coupon.getStartDate()));
            preparedStatement.setDate(6, Date.valueOf(coupon.getEndDate()));
            preparedStatement.setInt(7, coupon.getAmount());
            preparedStatement.setDouble(8, coupon.getPrice());
            preparedStatement.setString(9, coupon.getImage());
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE " + DBManager.DB
                            + ".`coupons` SET `CATEGORY_ID` = '"+coupon.getCategory().getId()+"', " +
                            "`TITLE` = '"+coupon.getTitle()+"', " +
                            "`DESCRIPTION` = '"+coupon.getDescription()+"', " +
                            "`START_DATE` = '"+Date.valueOf(coupon.getStartDate())+"', " +
                            "`END_DATE` = '"+Date.valueOf(coupon.getEndDate())+"', " +
                            "`AMOUNT` = '"+coupon.getAmount()+"', " +
                            "`PRICE` = '"+coupon.getPrice()+"', " +
                            "`IMAGE` = '"+coupon.getImage()+"' " +
                            "WHERE (`ID` = '"+coupon.getId()+"')");
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public void deleteCoupon(int couponID) {
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM " + DBManager.DB
                            + ".`coupons` WHERE (`ID` = '"+couponID+"')");
            preparedStatement.execute();
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.restoreConnection(connection);
        }
    }

    @Override
    public ArrayList<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public Coupon getOneCoupon(int couponID) {
        return null;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {

    }
}
