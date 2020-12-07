package com.ibs.create;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibs.bean.BeanClass;
import com.ibs.connect.ConnectDisplay;



@WebServlet("/createemployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name_user=request.getParameter("uname");
		String pass_user=request.getParameter("pass");
		
		
		BeanClass bean=new ConnectDisplay().verify(name_user,pass_user);
		if(bean.getDept()!=null) {
			response.setContentType("text/html");
        	RequestDispatcher rd=request.getRequestDispatcher("Index.html");
            response.getWriter().print("<h1 style='color:red'>existing username or password </h1>");
            rd.include(request, response);
		}else {
			
			String stringid=request.getParameter("id");
			int id=Integer.parseInt(stringid);
			String firstname=request.getParameter("fname");
			String username=request.getParameter("uname");
			String password=request.getParameter("pass");
			String lastname=request.getParameter("lname");
			String department=request.getParameter("dept");
			String email=request.getParameter("mail");
			String stringsalary=request.getParameter("sal");
			int salary=Integer.parseInt(stringsalary);
			String choosehobbies="";
			String hobbies[]=request.getParameterValues("hobbs");
			for(int i=0;i<hobbies.length;i++)
			{
				choosehobbies+=hobbies[i]+",";
			}
			new ConnectDisplay().create(username, password, id, firstname, lastname, email, salary, department, choosehobbies);
			response.setContentType("text/html");
        	RequestDispatcher rd=request.getRequestDispatcher("Index.html");
            response.getWriter().print("<h1 style='color:red'>Succesful Entry </h1>");
            rd.include(request, response);
		}
		
	}

}
