<%@page import="entity.Employee" %>
<%@page import="service.EmployeeService" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! Employee emp;
%>

<% emp = (Employee)session.getAttribute("emp");
EmployeeService es = new EmployeeService();
List<Employee> list = es.getEmployee();
if(emp.isAdmin())
{
	
	
%>

<% }
else{ %>
	<div>Normal User</div>
<% }%>
  
<div class="container">
  <h2>Employee Table</h2>
            
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
      </tr>
    </thead>
    <tbody>
    <% for(int i=0; i< list.size(); i++ ){ %>
    
      <tr>
        <td><%=list.get(i).getEmpId() %>
        <td><%=list.get(i).getFirstName() %></td>
        <td><%=list.get(i).getLastName() %></td>
        <td><%=list.get(i).getSalary() %></td>  
      </tr>
     <% } %> 
     
    </tbody>
  </table>
</div>
</body>
</html>