package com.ibs.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ibs.bean.BeanClass;


public class ConnectDisplay {

	public  BeanClass verify(String username,String userpass) {
		BeanClass bean=new BeanClass();
		String verifyname="";
		String verifypass="";
		
		
		      Connection conn = null;
		      try {
		         Class.forName("org.postgresql.Driver");
		         conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project","postgres","adarsh");
		         Statement stmt=  conn.createStatement();
		         PreparedStatement pstmt=null;
		         ResultSet rs = stmt.executeQuery("select * from employees ");
		     
		                 
		                  rs = stmt.executeQuery("select * from employees ");
		                  while(rs.next()) {
		                  	verifyname=rs.getString("user_name");
		                  	verifypass=rs.getString("password");
		                  	if(username.equalsIgnoreCase(verifyname) && userpass.equalsIgnoreCase(verifypass)) break;
		                  	
		                  }
		                 
		                 if(username.equalsIgnoreCase(verifyname) && userpass.equalsIgnoreCase(verifypass)){
		                	 
		                	 pstmt=conn.prepareStatement("select * from employees where user_name=? and password=? ");
			                 pstmt.setString(1,username);
			                 pstmt.setString(2, userpass);
			                 rs=pstmt.executeQuery();
		                 while(rs.next())
		                 {
		                	
		                 	bean.setempid(rs.getInt("id"));
		                 	bean.setUsername(rs.getString("user_name"));
		                 	bean.setLname(rs.getString("last_name"));
		                 	bean.setempfname(rs.getString("first_name"));
		                 	bean.setMail(rs.getString("email"));
		                 	bean.setDept(rs.getString("department"));
		                 	bean.setempsalary(rs.getInt("salary"));
		                 	bean.setHobbies(rs.getString("hobbies"));
		                 	bean.setPass(rs.getString("password"));
		                 	
		                 	
		                 	
		                 }
		                 
		             
		      }
		      }catch(Exception e) {
		    	  System.out.println(e);
		      }
		      
		      
		      return bean;
	
		 
	}

	public void create(String username, String password, int id, String firstname, String lastname, String email,
			int salary, String department, String choosehobbies) {
		Connection conn = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project","postgres","adarsh");
		PreparedStatement p=conn.prepareStatement("insert into employees(user_name,password,id,first_name,last_name,email,salary,department,hobbies) values(?,?,?,?,?,?,?,?,?)");
		p.setString(1,username);
		p.setString(2, password);
		p.setInt(3, id);
		p.setString(4,firstname);
		p.setString(5, lastname);
		p.setString(6,email);
		p.setInt(7,salary);
		p.setString(8, department);
		p.setString(9, choosehobbies);
		
		p.executeUpdate();
		System.out.println(" successful entry!");
		
	}catch(Exception e ) {
		System.out.println(e);
	}
	}
}

