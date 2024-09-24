/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.controller;

import in.ems.db.DBOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sadhu
 */
@WebServlet(name = "RegistrationServ", urlPatterns = {"/RegistrationServ"})
public class RegistrationServ extends HttpServlet {

    private int eid;
    private String name;
    private String pwd;
    private String cpwd;
    private String email;
    private int mobile;
    
    DBOperations dbops=new DBOperations();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        fetchDetails(request);
        boolean status=false;
        
        dbops=new DBOperations();
         status=dbops.insertStudentDetails(eid,name,pwd,cpwd, email, mobile);
           if(status)
              response.sendRedirect("./success.jsp");
           else
               response.sendRedirect("./error.jsp");
         }
        
    private void fetchDetails(HttpServletRequest request){
        eid=Integer.parseInt(request.getParameter("eid"));
        name=request.getParameter("name");
        pwd=request.getParameter("pwd");
        cpwd=request.getParameter("cpwd");
        email=request.getParameter("email");
        mobile=Integer.parseInt(request.getParameter("mobile"));
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
