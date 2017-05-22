
package com;

import Service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            boolean value;
            System.out.println("inside the LoginServlet!!");
            HttpSession session=request.getSession();
           
            String u=request.getParameter("userName");
            String p=request.getParameter("password");
             session.setAttribute("userName", u);
            Service service=new Service();
           value= service.login(u, p);
          if(value==true){
               System.out.println("inside if");
              response.sendRedirect("SearchLocation.jsp");
             
                } else{
              System.out.println("inside else in LoginServlet");
              String message="Invalid UserName or Password!!!";
               response.sendRedirect("LoginPage.jsp?message1="+message);
          }   
        }
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
