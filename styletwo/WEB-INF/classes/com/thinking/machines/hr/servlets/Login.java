package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;

public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
AdministratorBean adminBean=(AdministratorBean)request.getAttribute("administratorBean");
if(adminBean==null)
{
try{
request.getRequestDispatcher("/LoginForm.jsp").forward(request,response);
}catch(Exception e)
{

}
}

String username=adminBean.getUsername();

AdministratorDAO adminDAO=new AdministratorDAO();

try{
adminDAO.getByUsername(username);
HttpSession session=request.getSession();
AdministratorBean ab=new AdministratorBean(username,adminBean.getPassword());

session.setAttribute("administratorBean",ab);

try{
request.getRequestDispatcher("/index.jsp").forward(request,response);
}catch(Exception e)
{

}


}catch(Exception exception)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username / password");
request.setAttribute("errorBean",errorBean);
try{
request.getRequestDispatcher("/LoginForm.jsp").forward(request,response);
}catch(Exception e)
{

}

}

}
}