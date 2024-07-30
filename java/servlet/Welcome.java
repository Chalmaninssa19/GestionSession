/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import connection.GConnection;
import gestionSession.Session;
import gestionSession.SessionObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import object.User;

public class Welcome extends HttpServlet {

     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          
          try {
             
          } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
          }
     }

     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          try {
           /* Connection conn = GConnection.getSimpleConnection();
   
                SessionObject so = new SessionObject(req.getSession().getId());
                Session session = new Session(so, conn);
                User user = (User)session.getAttribute("user"); 
                 
                    System.out.println("User : "+user);
                req.setAttribute("user", user);
              
              conn.close();*/
        } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("pages/welcome.jsp");
        dispat.forward(req, res);
    }
}