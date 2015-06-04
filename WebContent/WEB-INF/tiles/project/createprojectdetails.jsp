<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:eval var="enterProjectFunding" expression="@ValidationMessages.getProperty('Project.funding.sources.placeholder')" />
<spring:eval var="enterProjectScope" expression="@ValidationMessages.getProperty('Project.scope.placeholder')" />
<spring:eval var="enterProjectMilestones" expression="@ValidationMessages.getProperty('Project.milestones.placeholder')" />
<spring:eval var="enterProjectDependencies" expression="@ValidationMessages.getProperty('Project.dependencies.placeholder')" />
<spring:eval var="enterProjectConstraints" expression="@ValidationMessages.getProperty('Project.constraints.placeholder')" />
<spring:eval var="enterProjectDocumentLinks" expression="@ValidationMessages.getProperty('Project.document.links.placeholder')" />
<spring:eval var="enterProjectRisks" expression="@ValidationMessages.getProperty('Project.risks.placeholder')" />
<spring:eval var="enterProjectAssumptions" expression="@ValidationMessages.getProperty('Project.assumptions.placeholder')" />
<spring:eval var="enterProjectOtherLinks" expression="@ValidationMessages.getProperty('Project.other.links.placeholder')" />
<spring:eval var="enterProjectSocialMedia" expression="@ValidationMessages.getProperty('Project.social.media.placeholder')" />
<spring:eval var="enterProjectLocations" expression="@ValidationMessages.getProperty('Project.locations.placeholder')" />

<div id="nosearchresultstitle"><h2>Create The Project Details [Optional Fields]</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<div id="searchresult"></div>
<div id="nosearchresults">

<div id="createprojectdetails">

<sf:form method="post" commandName="projectDetails">

<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />

<sf:input type="hidden" name="id" path="id" />
<sf:input type="hidden" name="projectId" path="projectId" />

<table>

<tr>
<td class="createproject_tablecell">
Funding Sources<br />
<spring:bind path="fundingSources">
<sf:textarea path="fundingSources" name="fundingSources" placeholder="${enterProjectFunding}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Scope<br />
<spring:bind path="scope">
<sf:textarea path="scope" name="scope" placeholder="${enterProjectScope}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Milestones<br />
<spring:bind path="milestones">
<sf:textarea path="milestones" name="milestones" placeholder="${enterProjectMilestones}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Dependencies<br />
<spring:bind path="dependencies">
<sf:textarea path="dependencies" name="dependencies" placeholder="${enterProjectDependencies}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Constraints<br />
<spring:bind path="constraints">
<sf:textarea path="constraints" name="constraints" placeholder="${enterProjectConstraints}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Document Links<br />
<spring:bind path="documentLinks">
<sf:textarea path="documentLinks" name="documentLinks" placeholder="${enterProjectDocumentLinks}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Risks<br />
<spring:bind path="risks">
<sf:textarea path="risks" name="risks" placeholder="${enterProjectRisks}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Project Assumptions<br />
<spring:bind path="assumptions">
<sf:textarea path="assumptions" name="assumptions" placeholder="${enterProjectAssumptions}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Other Links<br />
<spring:bind path="otherLinks">
<sf:textarea path="otherLinks" name="otherLinks" placeholder="${enterProjectOtherLinks}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Social Media<br />
<spring:bind path="socialMedia">
<sf:textarea path="socialMedia" name="socialMedia" placeholder="${enterProjectSocialMedia}" cssClass="createproject_two"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Locations<br />
<spring:bind path="locations">
<sf:textarea path="locations" name="locations" placeholder="${enterProjectLocations}" cssClass="createproject_two"></sf:textarea><br />
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
<input type="submit" name="_eventId_submit" value="Save/Next" />
</td></tr>

</table>
</sf:form>

</div>

</div>
