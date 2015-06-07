<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<h2>Search Projects Results</h2>

<%-- Right now this file is a temporary placeholder. --%>
<%-- We can bring it back if a user wants to view an actual full search bar page. --%>

<sf:form method="post" id="searchForm" commandName="projectSearch">
	<table class="formtable">
		<tr>
			<td><sf:input type="text" path="searchString" id="searchtextbox" placeholder="Search..." value="" /></td>
			<td><input type="submit" value="Search" /></td>
		</tr>
	</table>
</sf:form>

<div id="result"></div>


