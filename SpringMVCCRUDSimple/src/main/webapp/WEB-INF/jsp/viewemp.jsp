    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>FirstName</th><th>SecondName</th><th>email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${cus.id}</td>
    <td>${cus.FirstName}</td>
    <td>${cus.SecondName}</td>
    <td>${cus.email}</td>
    <td><a href="editcus/${cus.id}">Edit</a></td>
    <td><a href="deletecus/${cus.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="cusform">Add New Customer</a>