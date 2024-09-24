import java.sql.*; // JDBC API 

public class JDBCDemo2 {
   
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url ="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pwd = "";
        Connection con = DriverManager.getConnection(url,uname,pwd);
        
        if(con!=null)
            System.out.println("Connection established");
        Statement st = con.createStatement();
        String q1 = "create table customer(cid int, cname varchar(10), balance float, city varchar(10), PRIMARY KEY(cid))";
        
        int x = st.executeUpdate(q1);
       
        
        System.out.println(x);
        con.close();
        st.close();
    }
}
