package model;
import static controller.CommonOperations.*;
import static controller.CustomerOperations.*;

public class Customer {
    private int customer_Id;
    private String customer_Name;
    private String customer_Gmail;
    private long customer_Number;
    private String customer_Password;
    public Customer()
    {
        this.customer_Gmail=null;
        this.customer_Password=null;
        this.customer_Name=null;
        this.customer_Number=0;
    }
    public Customer(int customer_Id,String customer_Gmail,String customer_Password,String customer_Name,long customer_Number) {
        this.customer_Id=customer_Id;
        this.customer_Gmail=customer_Gmail;
        this.customer_Password=customer_Password;
        this.customer_Name=customer_Name;
        this.customer_Number=customer_Number;
    }
    public void setCustomerId(int customer_Id)
    {
        this.customer_Id=customer_Id;
    }
    public int getCustomerId()
    {
        return this.customer_Id;
    }
    public void setCustomerName(String customer_Name)
    {
        this.customer_Name=customer_Name;
    }
    public String getCustomerName()
    {
        return this.customer_Name;
    }
    public void setCustomerGmail(String customer_Gmail)
    {
        this.customer_Gmail=customer_Gmail;
    }
    public String getCustomerGmail()
    {
        return this.customer_Gmail;
    }
    public void setCustomerNumber(long customer_Number)
    {
        this.customer_Number=customer_Number;
    }
    public long getCustomerNumber()
    {
        return this.customer_Number;
    }
    public void setCustomerPassword(String customer_Password)
    {
        this.customer_Password=customer_Password;
    }
    public String getCustomerPassword()
    {
        return this.customer_Password;
    }
//    public void create_Customer_Account(String customer_Name,String customer_Password)
//    {
//        createCustomerAccount(this.customer_Gmail,customer_Password,customer_Name,this.customer_Number);
//    }
//    public static boolean valid_Customer(String customer_Gmail,String customer_Password)
//    {
//        return validCustomer(customer_Gmail,customer_Password);
//    }
//    public static void view_All_Mobiles()
//    {
//        viewAllMobiles();
//    }
//    public static void search_Mobiles(String mobileName)
//    {
//        searchMobiles(mobileName);
//    }
//    public static void add_To_Cart(String customer_Gmail,int mobile_Id)
//    {
//        addToCart(customer_Gmail,mobile_Id);
//    }
//    public static boolean view_Cart(String customer_Gmail)
//    {
//        return viewCart(customer_Gmail);
//    }
//    public static void remove_From_Cart(String customer_Gmail,int cart_Id,boolean msg)
//    {
//        removeFromCart(customer_Gmail,cart_Id,msg);
//    }
//    public static boolean cart_Exist(String customer_Gmail,int cart_Id)
//    {
//        return cartExist(customer_Gmail,cart_Id);
//    }
//    public static void purchase_Mobile(String customer_Gmail,int cart_Id)
//    {
//        purchaseMobile(customer_Gmail,cart_Id);
//    }
}
