<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:eval var="enterProjectGovernance" expression="@ValidationMessages.getProperty('Project.governance.placeholder')" />
<spring:eval var="enterProjectTeamStructure" expression="@ValidationMessages.getProperty('Project.team.structure.placeholder')" />
<spring:eval var="enterProjectRoles" expression="@ValidationMessages.getProperty('Project.roles.placeholder')" />
<spring:eval var="enterProjectFacilities" expression="@ValidationMessages.getProperty('Project.facilities.placeholder')" />
<spring:eval var="enterProjectResources" expression="@ValidationMessages.getProperty('Project.resources.placeholder')" />

<div id="nosearchresultstitle"><h2>Create the Project Governance [Optional Fields]</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<div id="searchresult"></div>
<div id="nosearchresults">

<div id="createprojectorganization">

<sf:form method="post" commandName="projectOrganization">

<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />

<sf:input type="hidden" name="id" path="id" />
<sf:input type="hidden" name="projectId" path="projectId" />

<table>

<tr>
<td class="createproject_tablecell">
Project Governance<br />
<spring:bind path="governance">
<sf:textarea path="governance" name="governance" placeholder="${enterProjectGovernance}" cssClass="createproject_three"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Team Structure<br />
<spring:bind path="teamStructure">
<sf:textarea path="teamStructure" name="teamStructure" placeholder="${enterProjectTeamStructure}" cssClass="createproject_three"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Roles and Responsibilities<br />
<spring:bind path="rolesResponsibilities">
<sf:textarea path="rolesResponsibilities" name="rolesResponsibilities" placeholder="${enterProjectRoles}" cssClass="createproject_three"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Facilities<br />
<spring:bind path="facilities">
<sf:textarea path="facilities" name="facilities" placeholder="${enterProjectFacilities}" cssClass="createproject_three"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Resources<br />
<spring:bind path="resources">
<sf:textarea path="resources" name="resources" placeholder="${enterProjectResources}" cssClass="createproject_three"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
</td>
</tr>

<tr><td><br />
<input type="submit" name="_eventId_back" value="Back" />&nbsp;
<input type="submit" name="_eventId_submit" value="Save Project" />
</td></tr>

</table>
</sf:form>

</div>

</div>
