package com.thinking.machines.hr.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;


public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
//DesignationBean designationBean=request.getAttribute("designationBean");
DesignationDTO designationDTO=new DesignationDTO();
//designationDTO.setCode(designationBean.getCode());
//designationDTO.setTitle(designationBean.getTitle());

designationDTO.setCode(Integer.parseInt(request.getParameter("code")));
designationDTO.setTitle(request.getParameter("title"));
DesignationDAO designationDAO=new DesignationDAO();
try{
designationDAO.update(designationDTO);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation (Edit Module)");
messageBean.setMessage("Designation updated");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("ok");
messageBean.setButtonOneAction("/Designations.jsp");

request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}
catch(Exception exception)
{
// if it comes here then there could be some problem and we have to send the errorbean as well as designationBean and if we are not sending designation bean from here then DesignationEditForm will not be having any code to use for hidden form field and hence it will give error.

ErrorBean errorBean=new ErrorBean();
errorBean.setError(exception.getMessage());
request.setAttribute("errorBean",errorBean);
DesignationBean designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
try{
request.getRequestDispatcher("/DesignationEditForm.jsp").forward(request,response);
}
catch(Exception except)
{

}

}// catch ends here

}// function ends here
}