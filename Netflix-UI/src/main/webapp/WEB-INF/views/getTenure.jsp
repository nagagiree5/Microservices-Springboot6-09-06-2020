<%@taglib   uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

<br>
Tenure
<c:forEach items="${tenure}" var="t"><br><hr>
Tenure Id :<c:out value="${t.id}"></c:out> <br>
Phone Nor :<c:out value="${t.mobile}"></c:out> <br>
Email :<c:out value="${t.gmail}"></c:out> <br>
Plan Name :<c:out value="${t.plan}"></c:out> <br>
Start :<c:out value="${t.start}"></c:out> <br>
Stop :<c:out value="${t.stop}"></c:out> <br>
DurationInHrs :<c:out value="${t.durationInHrs}"></c:out> <br>
</c:forEach>


<br>

<hr>