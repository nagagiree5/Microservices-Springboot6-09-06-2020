<%@taglib   uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<br>

User details<br><hr>
Phone Number : <c:out value="${user.phoneNor}"></c:out><br>
User Name : <c:out value="${user.userName}"></c:out><br>
Email : <c:out value="${user.email}"></c:out><br>
<br>
Current Plan <br><hr>
PlanId : <c:out value="${user.currentPlan.planId}"></c:out><br>
Plan Name : <c:out value="${user.currentPlan.planName}"></c:out><br>
Price PerMonth : <c:out value="${user.currentPlan.pricePerMonth}"></c:out><br>
FeaturesProvide : <c:out value="${user.currentPlan.featuresProvide}"></c:out><br>
<br>
devicesConnected <br><hr>

<c:forEach items="${user.devicesConnected}" var="d">
<c:out value="${d.device}"></c:out> <br>
</c:forEach>
<hr>
<br>
<br>
