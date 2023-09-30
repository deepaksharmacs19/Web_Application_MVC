package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;

public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
try{
request.getRequestDispatcher("/LoginForm.jsp").forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
{
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
try{
DesignationDAO designationDAO=new DesignationDAO();
designationDAO.deleteByCode(designationBean.getCode());

MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation (Delete Module)");
messageBean.setMessage("Designation deleted");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("ok");
messageBean.setButtonOneAction("/Designations.jsp");

request.setAttribute("messageBean",messageBean);
request.getRequestDispatcher("/Notification.jsp").forward(request,response);
}
catch(Exception exception)
{
System.out.println(exception);	
try{
request.getRequestDispatcher("/Designations.jsp").forward(request,response);
}
catch(Exception except)
{

}

}

}
}