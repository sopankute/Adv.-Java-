import java.sql.*;
import java.util.Scanner;

public class BatchTxDemo {
    public static void main(String[] args) throws Exception {
    DBConnection dbcon = new DBConnection();  // class - getDBConnection()
    Connection con = dbcon.getDBConnection(); // load and connecting - return con
    if(con != null)
        System.out.println("Connected!!");
  
    con.setAutoCommit(false); // setting commit() false 
    
    Scanner input = new Scanner(System.in);
        System.out.println("Enter source cid: ");
        int sid = input.nextInt();
        System.out.println("Enter destination cid:");
        int did = input.nextInt();
        System.out.println("Hoe much Amount? ");
        double amt = input.nextDouble();
         
        Statement st = con.createStatement();
        String q1 ="update customers set balance = balance - "+amt+" where cid ="+sid; 
        String q2 ="update customers set balance = balance + "+amt+" where cid ="+did;
        // adding to the batch
        st.addBatch(q1);
        st.addBatch(q2);
        // executimg batch
        int[] x = st.executeBatch(); // 2
        
        // whether to commit or rollback
        boolean flag = false;
        for( int i=0; i<x.length;i++){  // 2
            System.out.println("X values:"+x[i]);
            if(x[i] == 0){
                flag = true;
                break;
            }
        }
        
        if(flag == true){
            con.rollback();
            System.out.println("Transaction rolled back!");
        }
        else{
            con.commit();
            System.out.println("Transaction committed!");
        }
        
        con.close();
        st.close();
  
    }
    
}
