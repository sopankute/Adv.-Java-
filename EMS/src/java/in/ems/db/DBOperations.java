/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.db;

import in.ems.util.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sadhu
 */
public class DBOperations {
    DBConnection dbcon=null;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String query=null;
    
    public boolean insertStudentDetails(int eid,String name,String pwd, String cpwd, String email, int mobile){
        dbcon=new DBConnection();
        con=dbcon.getConnection();
        query="insert into emp values(?,?,?,?,?,?)";
        int result=0;
      
        try{
        con.setAutoCommit(false);
        pst=con.prepareStatement(query);
        pst.setInt(1, eid);
        pst.setString(2, name);
        pst.setString(3, pwd);
        pst.setString(4, cpwd);
        pst.setString(5, email);
        pst.setInt(6, mobile);
        
        result=pst.executeUpdate();
        
        con.commit();
        
        if(result==1)
        return true;
        
        }
        catch(Exception e){    
        }
        finally{
            try{
            con.close();
            pst.close();
            }
            catch(Exception e){
        }
        }
        
        return false;
    }
    public List<Employee> validateLogin(){
        dbcon=new DBConnection();
        con=dbcon.getConnection();
       
        query="select name, pwd from emp";
       
        List<Employee> empList=new ArrayList();
        Employee emp=null;
        
        try{
        pst=con.prepareStatement(query);
        rs=pst.executeQuery();
        
        while(rs.next()){
             emp=new Employee();
             emp.setName(rs.getString(1));
             emp.setPwd(rs.getString(2));
        
             empList.add(emp);
        }    
           
        }
        catch(Exception e){    
        }
        finally{
            try{
            con.close();
            pst.close();
            rs.close();
            }
            catch(Exception e){
        }
    }
         return empList;

    } 
}
    
    

