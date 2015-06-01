<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
<!--
// Put focus on user name field
$(document).ready(function(){
	document.f.j_username.focus();
});
//-->
</script>

<h2>Login with Username and Password</h2>

<c:if test="${param.error != null}">
	<p class="error">Login failed.  Check that you're user name and pwd are correct.</p>
</c:if>

<jsp:include page="/WEB-INF/tiles/contentlayout.jsp">
	<jsp:param name="page" value="/WEB-INF/tiles/account/logincontent.jsp"/>
</jsp:include>


