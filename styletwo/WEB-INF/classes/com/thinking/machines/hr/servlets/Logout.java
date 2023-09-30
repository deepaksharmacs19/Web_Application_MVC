package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Logout extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
HttpSession session=request.getSession();
session.removeAttribute("administratorBean");
try{
request.getRequestDispatcher("/LoginForm.jsp").forward(request,response);
}
catch(Exception e)
{

}

}
}