package controller;
import model.Admin;
import model.Cart;
import model.Customer;

import static model.DBConnection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOperations {
    public static void createCustomerAccount(Customer customer)
    {
        String query="Insert into Customer(Customer_Gmail,Customer_Password,Customer_Name,Customer_Number) Values(?,?,?,?);";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,customer.getCustomerGmail());
            fix.setString(2,customer.getCustomerPassword());
            fix.setString(3,customer.getCustomerName());
            fix.setLong(4,customer.getCustomerNumber());
            fix.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Customer validCustomer(String gmail, String password) {
        String query="select * From Customer where Customer_Gmail=? and Customer_Password=?;";
        try {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,gmail);
            fix.setString(2,password);
            ResultSet result= fix.executeQuery();
            boolean b=result.next();
            if(b) {
                return new Customer(result.getInt("Customer_Id"),result.getString("Customer_Gmail"),result.getString("Customer_Password"),result.getString("Customer_Name"),result.getLong("Customer_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void addToCart(int customer_Id,int mobile_Id)
    {
        String query="insert into Cart(Customer_Id,Mobile_Id) Values(?,?);";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer_Id);
            fix.setInt(2,mobile_Id);
            fix.execute();
            System.out.println("Mobile Is Added To Cart Successfully...!");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static boolean containMobile(int mobile_Id)
    {
        String query="Select * from Mobile where Mobile_Id=?;";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,mobile_Id);
            ResultSet result=fix.executeQuery();
            return result.next();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static ArrayList<Cart> viewCart(Customer customer)
    {
        String query="Select * from Cart where Customer_Id=?;";
        try
        {
            ArrayList<Cart> cart=new ArrayList<Cart>();
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer.getCustomerId());
            ResultSet result= fix.executeQuery();
            while(result.next()) {
                cart.add(new Cart(result.getInt("Cart_Id"),result.getInt("Customer_Id"),result.getInt("Mobile_Id")));
            }
            return cart;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void mobile_Details(int mobile_Id)
    {
        String query="Select * from Mobile where Mobile_Id=?;";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,mobile_Id);
            ResultSet result= fix.executeQuery();
            if(result.next())
            {
                System.out.println("Mobile Id : "+result.getInt("Mobile_Id"));
                System.out.println("Mobile Name : "+result.getString("Mobile_Name"));
                System.out.println("Mobile Price : "+result.getInt("Mobile_Price"));
                String[] mobile_Description= result.getString("Mobile_Description").split(",");
                for (String s : mobile_Description) {
                    System.out.println(s);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void removeFromCart(Customer customer,int cart_Id,boolean msg)
    {
        String query="Delete From Cart where Customer_Id=? and Cart_Id=?;";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer.getCustomerId());
            fix.setInt(2,cart_Id);
            fix.execute();
            if(msg)
            {
                System.out.println("-----------------------------------------");
                System.out.println("Mobile Removed From Cart Successfully...!");
                System.out.println("-----------------------------------------");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static Cart cartExist(Customer customer,int cart_Id)
    {
        String query="Select * from Cart where Customer_Id=? and Cart_Id=?;";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer.getCustomerId());
            fix.setInt(2,cart_Id);
            ResultSet result= fix.executeQuery();
            if(result.next())
            {
                return new Cart(result.getInt("Cart_Id"),result.getInt("Customer_Id"),result.getInt("Mobile_Id"));
            }
            return null;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void purchaseMobile(Customer customer,int cart_Id)
    {
        String query="select * from Cart where Customer_Id=? and Cart_Id=?;";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer.getCustomerId());
            fix.setInt(2,cart_Id);
            ResultSet result= fix.executeQuery();
            if(result.next())
            {
                boolean available=containMobile(result.getInt("Mobile_Id"));
                if(available) {
                    System.out.println("-------------- Bill --------------");
                    System.out.println("Customer_Id : "+customer.getCustomerId());
                    System.out.println("Customer_Id : "+customer.getCustomerName());
                    System.out.println("Customer_Id : "+customer.getCustomerGmail());
                    System.out.println("Customer_Id : "+customer.getCustomerNumber());
                    mobile_Details(result.getInt("Mobile_Id"));
                    System.out.println("Thank You For Your Purchase...!");
                    System.out.println("----------------------------------");
                    transaction(customer.getCustomerId(), result.getInt("Mobile_Id"));
                }
                else {
                    System.out.println("---------------------------------------");
                    System.out.println("This Mobile Was Sold A Few Minutes Ago.\nSo,Please Purchase Another Mobile.");
                    System.out.println("---------------------------------------");
                }
                removeFromCart(customer, cart_Id, false);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void transaction(int customer_Id,int mobile_Id)
    {
        String query="Insert into Transaction(Customer_Id,Mobile_Id) Values(?,?);";
        try
        {
            PreparedStatement fix=getPreparedStatement(query);
            fix.setInt(1,customer_Id);
            fix.setInt(2,mobile_Id);
            fix.execute();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
