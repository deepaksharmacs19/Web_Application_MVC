package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NotifyFormResubmission extends HttpServlet
{ 

public void doPost(HttpServletRequest request, HttpServletResponse response)
{

try{
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("Forms are not to be resubmitted");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("ok");
messageBean.setButtonOneAction("/index.jsp");
request.setAttribute("messageBean",messageBean);

RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);

}
catch(Exception daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
try{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{

}

}
}

}