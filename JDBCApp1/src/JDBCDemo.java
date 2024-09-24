import java.sql.*;
public class JDBCDemo {
        public static void main(String[] args) throws Exception {
     
        Class.forName("com.mysql.cj.jdbc.Driver");
       
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        if(con !=null)
            System.out.println("Connection established");
        
        Statement st = con.createStatement();
        
        String query1 = "select count(*), min(sid), max(gpa), sum(gpa), avg(gpa) from student";
       
        ResultSet rs = st.executeQuery(query1);
        
        while(rs.next()){
            System.out.println("Rows:"+ rs.getInt(1));
            System.out.println("Min sid value:"+ rs.getInt(2));
            System.out.println("Max GPA:"+ rs.getDouble(3));
            System.out.println("Sum:"+ rs.getDouble(4));
            System.out.println("Average:"+ rs.getDouble(5));
        }
      
        con.close();
        st.close();
        rs.close();
    }
}
