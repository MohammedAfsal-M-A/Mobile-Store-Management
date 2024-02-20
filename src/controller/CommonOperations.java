package controller;

import model.Mobile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static model.DBConnection.getPreparedStatement;

public class CommonOperations {
    public static ArrayList<Mobile> viewAllMobiles()
    {
        String query="Select * from Mobile;";
        try
        {
            ArrayList<Mobile> mobiles=new ArrayList<Mobile>();
            PreparedStatement fix=getPreparedStatement(query);
            ResultSet result= fix.executeQuery();
            while(result.next())
            {
                mobiles.add(new Mobile(result.getInt("Mobile_Id"),result.getString("Mobile_Name"),result.getInt("Mobile_Price"),result.getString("Mobile_Description")));
            }
            return mobiles;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static ArrayList<Mobile> viewAllMobiles(String mobileName)
    {
        String query="Select * from Mobile where Mobile_Name like ? OR Mobile_Description like ?;";
        try
        {
            ArrayList<Mobile> mobiles=new ArrayList<Mobile>();
            PreparedStatement fix=getPreparedStatement(query);
            fix.setString(1,"%"+mobileName+"%");
            fix.setString(2,"%"+mobileName+"%");
            ResultSet result= fix.executeQuery();
            while(result.next())
            {
                mobiles.add(new Mobile(result.getInt("Mobile_Id"),result.getString("Mobile_Name"),result.getInt("Mobile_Price"),result.getString("Mobile_Description")));
            }
            return mobiles;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
