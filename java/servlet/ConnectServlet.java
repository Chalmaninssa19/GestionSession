/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "ConnectServlet", urlPatterns = {"/connect"})
public class ConnectServlet extends HttpServlet {

     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          
          try {
         out.print("get");
          } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
          }
          //RequestDispatcher dispat = req.getRequestDispatcher("listBesoinsServlet");
          //dispat.forward(req, res);
     }

     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          try {
            
out.print("post");
        } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
          }
         
    }
}