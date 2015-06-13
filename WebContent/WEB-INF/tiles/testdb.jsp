<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/myprojects">
select project_name, project_owner, project_short_description from projects
</sql:query>

<h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    Project Name: ${row.project_name}<br/>
    Project Owner: ${row.project_owner}<br/>
    Project Description: ${row.project_short_description}<br/>
</c:forEach>
