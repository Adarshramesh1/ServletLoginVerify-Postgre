<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import ="com.ibs.bean.BeanClass" %> 
<!DOCTYPE html>
<html>
<head>
<style>
div {
  background-color: #d5f4e6;
  font-size: large;
}
.button {
  background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin-left:300px;
  
}
h1{
color:red;
}

</style>
<script>
function myfunction(){
	<%BeanClass bean1=(BeanClass)request.getAttribute("Bean");%>
	document.getElementById('id').innerHTML="id of employee is :<%=bean1.getempid() %>";
	document.getElementById('fname').innerHTML="first name of employee is :<%=bean1.getempfname() %>";
	document.getElementById('lname').innerHTML="last name of employee is :<%=bean1.getLname() %>";
	document.getElementById('dept').innerHTML="department name of employee is :<%=bean1.getDept() %>";

	document.getElementById('sal').innerHTML="salary of employee is :<%=bean1.getempsalary() %>";
	document.getElementById('mail').innerHTML="mail id of employee is :<%=bean1.getMail() %>";
	document.getElementById('hobby').innerHTML="hobbies of the employee are :<%=bean1.getHobbies() %>";
	document.getElementById('homepage').innerHTML="Click here to retun to home page";
	

}
</script>
<meta charset="ISO-8859-1">
<title>Display Employee details</title>
</head>
<body>

<h1 Style="color:red">click the button below to show details of the Employee!</h1>
<input class="button" type="button" value="Show Details!" onclick="myfunction()"/><br/><br/>
<div id="id"> </div><br/>
<div id="fname"></div><br/>
<div id="lname"></div><br/>
<div id="dept"></div><br/>
<div id="mail"></div><br/>
<div id="sal"></div><br/>
<div id="hobby"></div><br/>
<a href="Index.html">
<h2 id='homepage'></h2>
</a>

</body>
</html>