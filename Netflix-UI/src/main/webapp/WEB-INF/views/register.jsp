<%@taglib   uri="http://www.springframework.org/tags/form"    prefix="form"%>
<%@taglib   uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<br> <br>
<c:if test="${message ne null }">
  <c:out value="${message }"/>
</c:if>
<hr>
<br>
<form:form action="addUser" method="post" modelAttribute="registerNetflixDTO">
<table>
    <tr>
      <td>PhoneNor</td>
      <td><form:input path="phoneNor"/></td>
      <td><form:errors path="phoneNor"/></td>
     </tr>
     <tr>
      <td>User Name</td>
      <td><form:input path="userName"/></td>
      <td><form:errors path="userName"/></td>
     </tr>
     <tr>
      <td>Password</td>
      <td><form:password path="password"/></td>
      <td><form:errors path="password"/></td>
     </tr>
       <tr>
      <td>Email</td>
      <td><form:input path="email"/></td>
      <td><form:errors path="email"/></td>
     </tr>
     
     <tr>
       <td>Plan id</td>
     <td>
     <form:select path="planId">
     <form:option value="">-----Select-----</form:option>
     <form:options items="${registerNetflixDTO.plansList}" itemValue="planId" itemLabel="planId" />
     </form:select>
	 </td> 
	 <td>
	 <form:errors path="planId"/>
	 </td> 
	    
<tr>
  <td colspan=3 align="center">
       <input type=submit value="REGISTER">
 </td> 
   </tr>
</table>

</form:form>

   




    