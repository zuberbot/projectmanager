<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:eval var="enterProjectName" expression="@ValidationMessages.getProperty('Project.name.placeholder')" />
<spring:eval var="enterProjectSummary" expression="@ValidationMessages.getProperty('Project.summary.placeholder')" />
<spring:eval var="enterProjectGoals" expression="@ValidationMessages.getProperty('Project.goals.placeholder')" />
<spring:eval var="enterProjectDeliverables" expression="@ValidationMessages.getProperty('Project.deliverables.placeholder')" />
<spring:eval var="enterProjectTargetAudience" expression="@ValidationMessages.getProperty('Project.target.audience.placeholder')" />

<div id="nosearchresultstitle"><h2>Create A Project</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>
<div id="searchresult"></div>
<div id="nosearchresults">

<script type="text/javascript">
<!--
// Put focus on user name field
$(document).ready(function() { document.createProjectForm.projectName.focus(); });
//-->
</script>

<div id="createproject">

<%-- commandName is the name of an attribute in the model --%>
<sf:form name="createProjectForm" method="post" commandName="project">

<%-- Enables web flow to know where in the flow we're at --%>
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
<%-- _eventId tells WebFlow to transition from view state to the next upon submit --%>
<input type="hidden" name="_eventId" value="send" />

<sf:input type="hidden" name="id" path="id" />
<sf:input type="hidden" name="projectOwner" path="projectOwner" value="${projectOwner}" />

<table>

<tr>
<td class="createproject_tablecell">
Project Name<br />
<spring:bind path="projectName">
<sf:input type="text" path="projectName" name="projectName" placeholder="${enterProjectName}" style="width: 375px;" />
	<c:if test="${status.error}">
		<span class="error"><br /><c:out value="${status.errorMessage}"/></span>
		<%-- Replaces: <sf:errors path="projectName" cssClass="error"></sf:errors> --%>
	</c:if>
</spring:bind>
</td>

<td>
Project Cost Estimate<br />
<spring:bind path="costEstimate">
<sf:input type="text" path="costEstimate" name="costEstimate" value="$0.00" style="width: 375px;" />
	<c:if test="${status.error}">
		<span class="error"><br /><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Summary<br />
<spring:bind path="projectShortDescription">
<sf:textarea path="projectShortDescription" name="projectShortDescription" placeholder="${enterProjectSummary}" cssClass="createproject_one"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>

<td>
Project Goals<br />
<spring:bind path="goalsObjectives">
<sf:textarea path="goalsObjectives" name="goalsObjectives" placeholder="${enterProjectGoals}" cssClass="createproject_one"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr>
<td class="createproject_tablecell">
Project Deliverables<br />
<spring:bind path="deliverables">
<sf:textarea path="deliverables" name="deliverables" placeholder="${enterProjectDeliverables}" cssClass="createproject_one"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
<td>
Target Audience<br />
<spring:bind path="targetAudience">
<sf:textarea path="targetAudience" name="targetAudience" placeholder="${enterProjectTargetAudience}" cssClass="createproject_one"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr><td><br /><input type="submit" value="Save/Next" /></td></tr>

</table>
</sf:form>

</div>

</div>
