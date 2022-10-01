<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Customer</h1>
       <form:form method="POST" action="/SpringMVCCRUDSimple/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>FirstName : </td> 
          <td><form:input path="FirstName"  /></td>
         </tr>  
         <tr>  
          <td>SecondName :</td>  
          <td><form:input path="SecondName" /></td>
         </tr> 
         <tr>  
          <td>email :</td>  
          <td><form:input path="email" /></td>
         </tr> 
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
