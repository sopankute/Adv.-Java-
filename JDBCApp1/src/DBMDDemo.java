import java.sql.*;

public class DBMDDemo {
    
    public static void main(String[] args)  throws Exception{
        
          
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected");
        
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println(dbmd.getDatabaseMajorVersion());
        System.out.println(dbmd.getDatabaseProductVersion());
        System.out.println(dbmd.getUserName());
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getDriverVersion());
        
        con.close();
        
    }
}
