package server;

import java.sql.*;

public class Connect_db {     
	// JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL="jdbc:mysql://localhost/META_PARKING";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";
    static Connection con=null;
    static Statement st=null;
    public static Statement getConnection()
    {
        if (con != null) return st;
        // get db, user, pass from settings file
        return getConnection(DB_URL, USER, PASS);
    }

    private static Statement getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(DB_URL, USER, PASS);
             st = con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return st;        
    }
} 
