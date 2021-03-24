<%@taglib   uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<br> <br>
<c:if test="${message ne null }">
  <c:out value="${message }"/>
</c:if>
<hr>
<br> 

New user sign up?   &nbsp;&nbsp;
<a href="registerPage" style="color:#FF0000;">sign up-->></a>

<br> <br>
Existing user sign in? &nbsp; &nbsp;
<a href="loginPage" style="color:#FF0000;">sign in-->></a>