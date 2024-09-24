/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.controller;

import in.ems.db.DBOperations;
import in.ems.util.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sadhu
 */
@WebServlet(name = "LoginServ", urlPatterns = {"/LoginServ"})
public class LoginServ extends HttpServlet {
    
    private String name;
    private String pwd;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        name=request.getParameter("name");
        pwd=request.getParameter("pwd");
        
        System.out.println(name+" "+pwd);  
        
        List<Employee> empList=null;
        
        DBOperations dbops=new DBOperations();
        empList=dbops.validateLogin();
        
        System.out.println(empList);
        boolean flag=false;
        for (Employee e:empList){
            if(e.getName().equals(name) && e.getPwd().equals(pwd)){
                flag=true;
                break;
            }
            }
            if(flag==true)
            response.sendRedirect("./loginsuccess.jsp");
            else
           response.sendRedirect("./loginerror.jsp");
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
