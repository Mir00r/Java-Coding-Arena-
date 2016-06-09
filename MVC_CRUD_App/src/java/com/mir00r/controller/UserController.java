/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.controller;

import com.mir00r.dao.UserDao;
import com.mir00r.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author Abdur Razzak <abdur.razzaq06@gmail.com>
 *  
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final long serialVersionID = 1L;
    private static final String INSERT_OR_EDIT = "/user.jsp";
    private static final String LIST_USER = "/listuser.jsp";
    private UserDao dao;
    
    public UserController() {
        super();
        dao = new UserDao();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String forward="";
        String action = request.getParameter("action");
        
        if ( action.equalsIgnoreCase("delete") ) {
            String userId = request.getParameter("userId");
            dao.DeleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.GetAllUsers());
        }
        else if ( action.equalsIgnoreCase("edit") ) {
            String userId = request.getParameter("userId");
            forward = INSERT_OR_EDIT;
            User user = dao.GetUserById(userId);
            request.setAttribute("user", user);
        }
        else if ( action.equalsIgnoreCase("listuser") ) {
            forward = LIST_USER;
            request.setAttribute("users", dao.GetAllUsers());
        }
       
        else{
            forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher RD = request.getRequestDispatcher(forward);
        RD.forward(request, response);
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
        User user = new User();
        
        user.setUname(request.getParameter("uname"));
        user.setPassword(request.getParameter("pass"));
        
        try {
            Date reg = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dob"));
            System.out.println("RRRRRRrrrrrrr" +reg);
            
            user.setRegisteredon(reg);
        } 
        catch (Exception exp) {
            exp.printStackTrace();
        }
        
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("uname");
        
        //        if(userid == null || userid.isEmpty())
//        {
//            dao.AddUser(user);
//        }
//        else
//        {
            user.setUname(userid);
            dao.CheckUser(user);
//        }
        RequestDispatcher RD = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.GetAllUsers());
        RD.forward(request, response);
    }

    

}
