import java.sql.*;

public class CallableDemo {
  
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected");
        
        String str1 = "{CALL getDetails(?)}";
        CallableStatement cst = con.prepareCall(str1);
        cst.setInt(1, 5555);
        
        ResultSet rs = cst.executeQuery();
        
        while(rs.next())
        System.out.print(rs.getInt(1)+ "\t\t"+ rs.getString(2)+"\t\t "+rs.getDouble(3)+"\t\t "+rs.getString(4));
        
        con.close();
        cst.close();
    }
}
