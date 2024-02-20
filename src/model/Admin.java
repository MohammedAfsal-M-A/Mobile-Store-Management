package model;
import static controller.CommonOperations.*;
import static controller.AdminOperations.*;

public class Admin
{
    private int admin_Id;
    private String admin_Name;
    private String admin_Gmail;
    private String admin_Password;
    private long admin_Number;
    public Admin()
    {
        this.admin_Id=0;
        this.admin_Gmail=null;
        this.admin_Password=null;
        this.admin_Name=null;
        this.admin_Number=0;
    }
    public Admin(int admin_Id,String admin_Gmail,String admin_Password,String admin_Name,long admin_Number)
    {
        this.admin_Id=admin_Id;
        this.admin_Gmail=admin_Gmail;
        this.admin_Password=admin_Password;
        this.admin_Name=admin_Name;
        this.admin_Number=admin_Number;
    }
    public void setAdminId(int admin_Id)
    {
        this.admin_Id=admin_Id;
    }
    public int getAdminId()
    {
        return this.admin_Id;
    }
    public void setAdminName(String admin_Name)
    {
        this.admin_Name=admin_Name;
    }
    public String getAdminName()
    {
        return this.admin_Name;
    }
    public void setAdminPassword(String admin_Password)
    {
        this.admin_Password=admin_Password;
    }
    public String getAdminPassword()
    {
        return this.admin_Password;
    }
    public void setAdminGmail(String admin_Gmail)
    {
        this.admin_Gmail=admin_Gmail;
    }
    public String getAdminGmail()
    {
        return this.admin_Gmail;
    }
    public void setAdminNumber(long admin_Number)
    {
        this.admin_Number=admin_Number;
    }
    public long getAdminNumber()
    {
        return this.admin_Number;
    }
//    public void create_Admin_Account(Admin admin)
//    {
//        create_Admin_Account_Account(admin);
//    }
//    public static boolean valid_Admin(String admin_Gmail,String admin_Password)
//    {
//        return validAdmin(admin_Gmail,admin_Password);
//    }
//    public static void view_All_Mobiles()
//    {
//        viewAllMobiles();
//    }
//    public static void search_Mobiles(String mobileName)
//    {
//        searchMobiles(mobileName);
//    }
//    public static void remove_Mobile(int mobileId)
//    {
//        removeMobile(mobileId);
//    }
//    public static void see_Transactions()
//    {
//        seeTransactions();
//    }
}
