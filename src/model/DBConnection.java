package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class DBConnection {
    private static Connection con=null;
    private DBConnection(){
        String mySQL_Url = "jdbc:mysql://localhost:3306/mobileStoreManagement";
        String mySQL_User = "root";
        String mySQL_Password = "Apshuammu1222@";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mySQL_Url,mySQL_User,mySQL_Password);
        }
        catch (ClassNotFoundException|SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void createConn()
    {
        DBConnection obj=new DBConnection();
    }
    public static PreparedStatement getPreparedStatement(String query) throws SQLException
    {
        return con.prepareStatement(query);
    }
    public static void closeConn()
    {
        try
        {
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
