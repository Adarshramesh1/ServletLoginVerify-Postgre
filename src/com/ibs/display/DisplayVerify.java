package com.ibs.display;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibs.bean.BeanClass;
import com.ibs.connect.ConnectDisplay;


@WebServlet("/Display_verify")
public class DisplayVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name_user=request.getParameter("username");
		String pass_user=request.getParameter("pass");
		
		
		BeanClass bean=new ConnectDisplay().verify(name_user,pass_user);
		
		if(bean.getDept()!=null) {
			request.setAttribute("Bean", bean);
			getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			response.setContentType("text/html");
        	RequestDispatcher rd=request.getRequestDispatcher("Index.html");
            response.getWriter().print("<h1 style='color:red'>Invalid username or password </h1>");
            rd.include(request, response);
		}
		
	}

}
