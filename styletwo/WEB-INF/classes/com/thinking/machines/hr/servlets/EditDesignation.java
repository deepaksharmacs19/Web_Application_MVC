package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;

public class EditDesignation extends HttpServlet
{


public void doGet(HttpServletRequest request, HttpServletResponse response)
{
int code=Integer.parseInt(request.getParameter("code"));

try{
DesignationDAO designationDAO=new DesignationDAO();

DesignationDTO designationDTO;
designationDTO=designationDAO.getByCode(code);

DesignationBean designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);

}catch(Exception exception)
{
try{
request.getRequestDispatcher("/Designations.jsp").forward(request,response);
}catch(Exception except)
{

}

}
}
}