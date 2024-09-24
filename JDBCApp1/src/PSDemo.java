import java.sql.*;
import java.util.Scanner;

public class PSDemo {
    public static void main(String[] args) throws Exception{
        
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected");
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many customer records?");
        int n = input.nextInt();
        
        PreparedStatement pst = null;
        
        for(int i=0;i<n;i++){
            
            System.out.println("Enter customer "+ (i+1)+ "details");
            int id = input.nextInt(); // sid
            String name = input.next(); // sname
            double bal = input.nextDouble(); //balance
            String city = input.next();          
        
        String q1 = "insert into customers values(?,?,?,?)";
        pst = con.prepareStatement(q1);
        
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setDouble(3,bal);
        pst.setString(4,city);
         
        int x = pst.executeUpdate();
        
        if(x>0)
            System.out.println((i+1)+" record inserted!");
        }
        
        PreparedStatement pst1 = con.prepareStatement("select * from customers");
        ResultSet rs = pst1.executeQuery();
        
        while(rs.next())
            System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
        
        con.close();
        pst.close();
        rs.close();
    }
}
