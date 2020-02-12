package utility;

import java.sql.*;

//Connect_db.getConnection()
public class Connect_db {     
	// JDBC driver name and database URL 
   static  String DB_URL="jdbc:mysql://localhost/InventoryDB";

    //  Database credentials
    static String USER = "root";
    static String PASS = "root";
    static Connection con=null;

   public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }
} 
