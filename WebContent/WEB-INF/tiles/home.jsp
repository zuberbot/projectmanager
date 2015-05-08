<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
<!--
$(document).ready(function() {
	setTimeout(function() { $('#loggedoutmsg').fadeOut('slow'); }, 1000); 
});
//-->
</script>

<sec:authorize access="!isAuthenticated()">
	<div id="nosearchresultstitle"><h2>Welcome to Project Portal</h2></div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<div id="nosearchresultstitle"><h2>My Projects Portal</h2></div>
</sec:authorize>

<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<c:choose>
<c:when test="${not empty loggedout}">
	<p id="loggedoutmsg">${loggedout}</p>
</c:when>
<c:otherwise>
<%-- Can do something else here --%>
</c:otherwise>
</c:choose>

<div id="searchresult"></div>

<div id="nosearchresults">
<jsp:include page="/WEB-INF/tiles/contentlayout.jsp">
	<jsp:param name="page" value="homeintroduction.jsp"/>
</jsp:include>
</div>
