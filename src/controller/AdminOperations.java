package controller;

import model.Admin;
import model.Mobile;
import model.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static model.DBConnection.getPreparedStatement;

public class AdminOperations {
    public static void createAdminAccount(Admin admin) {
        String query="Insert into Admin(Admin_Gmail,Admin_Password,Admin_Name,Admin_Number) Values(?,?,?,?);";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,admin.getAdminGmail());
            fix.setString(2,admin.getAdminPassword());
            fix.setString(3,admin.getAdminName());
            fix.setLong(4,admin.getAdminNumber());
            fix.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Admin validAdmin(String gmail,String password) {
        String query="select * From Admin where Admin_Gmail=? and Admin_Password=?;";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,gmail);
            fix.setString(2,password);
            ResultSet result= fix.executeQuery();
            boolean b=result.next();
            if(b) {
                return new Admin(result.getInt("Admin_Id"),result.getString("Admin_Gmail"),result.getString("Admin_Password"),result.getString("Admin_Name"),result.getLong("Admin_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void addMobile(Mobile mobile) {
        String query="Insert into Mobile(Mobile_Name,Mobile_Price,Mobile_Description) values(?,?,?);";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,mobile.getMobileName());
            fix.setInt(2,mobile.getMobilePrice());
            fix.setString(3,mobile.getMobileDescription());
            fix.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void removeMobile(int mobileId) {
        String query="Delete From Mobile where Mobile_Id=?;";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,mobileId);
            fix.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Transaction> seeTransactions() {
        String query = "Select * From Transaction;";
        try {
            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            PreparedStatement fix = getPreparedStatement(query);
            ResultSet result = fix.executeQuery();
            while (result.next()) {
                transactions.add(new Transaction(result.getInt("Transaction_Id"), result.getInt("Customer_Id"), result.getInt("Mobile_Id")));
            }
            return transactions;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
