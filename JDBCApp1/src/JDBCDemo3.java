import java.sql.*;
import java.util.Scanner;

public class JDBCDemo3 {
    
    public static void main(String[] args) throws Exception {
       
    DBConnection dbcon = new DBConnection();  // class - getDBConnection()
    Connection con = dbcon.getDBConnection(); // load and connecting - return con
    if(con != null)
            System.out.println("Connected!!");
    
    Scanner input = new Scanner(System.in);
        System.out.println("pls enter cid to delete a record");
        int id = input.nextInt();
        
    Statement st = con.createStatement();
    String q1 = "delete from customers where cid ="+id;
    
    int x = st.executeUpdate(q1);
    if(x>0)
            System.out.println(x +" record(s) deleted ");
    else
            System.out.println("record(s) not deleted....pls check your input");
    
    String q2 = "select * from customers where balance > 30000";
    ResultSet rs = st.executeQuery(q2);
        
        while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
    
    con.close();
    st.close();
    rs.close();
        
    }
}
