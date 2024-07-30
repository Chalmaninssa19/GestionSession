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

@WebServlet(name = "LoginServlet", urlPatterns = {".    ./login"})
public class LoginServlet extends HttpServlet {

     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          
          try {
             out.println("GET LOGIN");
          } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
          }
     }

     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.setContentType("text/plain");
          PrintWriter out = res.getWriter();
          try {
              System.out.println("Tsiy");
              out.print("tafaa");
            /*Connection conn = GConnection.getSimpleConnection();
              
              // Obtenir la date actuelle
                Date date = new Date();

                // Convertir la Date en Timestamp
                Timestamp dateTimeNow = new Timestamp(date.getTime());

                User user = new User(req.getParameter("user"), req.getParameter("mdp"));
                if(user.login()) {
                    SessionObject so = new SessionObject(req.getSession().getId(), dateTimeNow);
                    Session session = new Session(so, conn);
                    session.setAttribute("user", user);   
                }
                else {
                    RequestDispatcher dispat = req.getRequestDispatcher("/");
                    dispat.forward(req, res);
                }
              
              conn.close();*/
        } catch (Exception exe) {
               req.setAttribute("erreur", exe.getMessage());
        }
        //RequestDispatcher dispat = req.getRequestDispatcher("welcome");
        //dispat.forward(req, res);
    }
}