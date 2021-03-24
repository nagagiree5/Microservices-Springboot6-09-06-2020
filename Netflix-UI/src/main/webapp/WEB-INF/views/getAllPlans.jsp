<%@taglib   uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

<br>
NetlixPlans
<c:forEach items="${plans}" var="p"><br><hr>
Plan Id :<c:out value="${p.planId}"></c:out> <br>
Plan Name :<c:out value="${p.planName}"></c:out> <br>
PricePerMonth :<c:out value="${p.pricePerMonth}"></c:out> <br>
FeaturesProvide :<c:out value="${p.featuresProvide}"></c:out> <br>

</c:forEach>
<hr>
<br>
<br>
