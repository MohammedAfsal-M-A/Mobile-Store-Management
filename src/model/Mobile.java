package model;
import static controller.AdminOperations.*;
import static controller.CustomerOperations.*;
public class Mobile
{
    private int mobile_Id;
    private String mobile_Name;
    private int mobile_Price;
    private String mobile_Description;
    public Mobile()
    {
        this.mobile_Id=0;
        this.mobile_Name=null;
        this.mobile_Price=0;
        this.mobile_Description=null;
    }
    public Mobile(int mobile_Id,String mobile_Name,int mobile_Price,String mobile_Description)
    {
        this.mobile_Id=mobile_Id;
        this.mobile_Name=mobile_Name;
        this.mobile_Price=mobile_Price;
        this.mobile_Description=mobile_Description;
    }
    public void setMobileId(int mobile_Id)
    {
        this.mobile_Id=mobile_Id;
    }
    public int getMobileId()
    {
        return this.mobile_Id;
    }
    public void setMobileName(String mobile_Name)
    {
        this.mobile_Name=mobile_Name;
    }
    public String getMobileName()
    {
        return this.mobile_Name;
    }
    public void setMobilePrice(int mobile_Price)
    {
        this.mobile_Price=mobile_Price;
    }
    public int getMobilePrice()
    {
        return this.mobile_Price;
    }
    public void setMobileDescription(String mobile_Description)
    {
        this.mobile_Description=mobile_Description;
    }
    public String getMobileDescription()
    {
        return this.mobile_Description;
    }
//    public void add_Mobile(Mobile mobile)
//    {
//        addMobile(mobile);
//    }
//    public static boolean contain_Mobile(int mobile_Id)
//    {
//        return containMobile(mobile_Id);
//    }

}
