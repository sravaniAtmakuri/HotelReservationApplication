package com;

import Service.Service;
import bean.CustomerBean;
import bean.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("In servlet Page");
        int i=0;
       CustomerBean customer=new CustomerBean();
       LoginBean login=new LoginBean();
       Service service=new Service();
       customer.setName(request.getParameter("name"));
       customer.setAddress(request.getParameter("address"));
       customer.setEmail(request.getParameter("email"));
       String phoneno=request.getParameter("phonenumber");
       System.out.println(phoneno);
       customer.setPhonenumber(phoneno);
       login.setUsername(request.getParameter("email"));
       login.setPassword(request.getParameter("password"));
      i= service.insertCustomer(customer);
       
       if(i>0){
           System.out.println("inside the RegistrationServlet in  if loop when the insertion into customer is successfull!!");
           service.insertIntoLogin(login);
           response.sendRedirect("loginPage.jsp");
       }else{
           String message2="Email Already exists, please provide another emailID";
           response.sendRedirect("RegistrationPage.jsp?message2="+message2);
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
    }

}
