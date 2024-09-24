import java.sql.*;

public class RSMDDemo  {

    public static void main(String[] args) throws Exception {
        
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected");
        
        Statement st = con.createStatement();
        String q1 = "select * from customers";
        ResultSet rs = st.executeQuery(q1);
        
        ResultSetMetaData rsmd = rs.getMetaData();
        // printing column names
        int colCount = rsmd.getColumnCount();
        
        for(int i=1; i<=colCount; i++)
            System.out.print(rsmd.getColumnName(i)+"\t\t");
        
        System.out.println("");
        
         for(int i=1; i<=colCount; i++)
            System.out.print(rsmd.getColumnTypeName(i)+"\t\t");
         
            System.out.println("");
         
          while(rs.next()){
             System.out.print(rs.getInt(1)+ "\t\t"+ rs.getString(2)+"\t\t "+rs.getDouble(3)+"\t\t "+rs.getString(4));
             System.out.println();
          }
        
        con.close();
        st.close();
        rs.close();
 
    }
    
}
