<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>Help</h2>

<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<div id="searchresult"></div>

<div id="nosearchresults">
<jsp:include page="/WEB-INF/tiles/contentlayout.jsp">
	<jsp:param name="page" value="helpinfo.jsp"/>
</jsp:include>
</div>
