<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:eval var="enterProjectBlogTitle" expression="@ValidationMessages.getProperty('Project.blog.title')" />
<spring:eval var="enterProjectBlogEntry" expression="@ValidationMessages.getProperty('Project.blog.entry')" />

<div id="nosearchresultstitle"><h2>${project.projectName}</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<div id="searchresult"></div>
<div id="nosearchresults">

<table>

<tr>
<td valign="top" id="projectdetailtablecell">

	<sf:form method="post" commandName="projectBlog" id="postBlog">
		<!-- Enables web flow to know where in the flow we're at -->
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
		<!-- Event id determines what happens when we submit form -->
		<!-- Tell WebFlow to transition from view state to the next -->
		<input type="hidden" name="_eventId" value="send" />
		
		<!-- Project ID -->
		<sf:input type="hidden" path="projectId" value="${project.id}" />
		
		<!-- Ensure BLOG post is Active -->
		<sf:input type="hidden" path="active" value="Y" />
		
		<table>
		<tr>
		<td>
		<spring:bind path="blogTitle">			
		<sf:input type="text" path="blogTitle" placeholder="${enterProjectBlogTitle}" value="" style="width: 350px;" /><br />
			<c:if test="${status.error}">
				<span class="error"><c:out value="${status.errorMessage}"/></span>
			</c:if>
		</spring:bind>
		</td>
		<td>
		&nbsp;
		<input type="submit" value="Post Blog" id="postblogbutton" />
		</td>
		</tr>

		<tr>
		<td colspan="2">		
		<spring:bind path="blogEntry">			
		<sf:textarea path="blogEntry" type="text" placeholder="${enterProjectBlogEntry}" value="" style="width: 450px;" /><br />
			<c:if test="${status.error}">
				<span class="error"><c:out value="${status.errorMessage}"/></span>
			</c:if>
		</spring:bind>
		</td>
		</tr>
		</table>		
		<br />
	</sf:form>

	<c:forEach var="projectBlogs" items="${projectBlogList}" varStatus="counter">
		<c:set var="numberOfBlogs" scope="session" value="${counter.index}"/>

		<c:if test="${counter.index < 6}">
			<span id="projectblogtitle"><c:out value="${projectBlogs.blogTitle}" /></span> - <c:out value="${projectBlogs.createdDate}" /><br />
			<span id="projectblogentry"><c:out value="${projectBlogs.blogEntry}" /></span>
			<br />
			<br />
		</c:if>
	</c:forEach>

	<c:if test="${numberOfBlogs > 5}">
		<a href="" id="numberofblogs"><span style="font-size: 30px;">&raquo;&raquo;&raquo;</span></a>
	</c:if>
</td>
<td valign="top">

<div id="projectdetailview">
	<table id="projectdetailviewtable">
	<tr><td><label id="projectdetail">Created:</label> <c:out value="${project.createdDate}" /></td></tr>
	<tr><td><label id="projectdetail">Last Updated:</label> <c:out value="${project.updatedLastDate}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Summary:</label> <c:out value="${project.projectShortDescription}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Objectives:</label> <c:out value="${project.goalsObjectives}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Deliverables:</label> <c:out value="${project.deliverables}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Target Audience:</label> <c:out value="${project.targetAudience}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Cost Estimate:</label> <c:out value="${project.costEstimate}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Risks:</label> <c:out value="${projectDetails.risks}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Document Links:</label> <c:out value="${projectDetails.documentLinks}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Other Links:</label> <c:out value="${projectDetails.otherLinks}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Social Media:</label> <c:out value="${projectDetails.socialMedia}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Team Structure:</label> <c:out value="${projectOrganization.teamStructure}" /><br /><br /></td></tr>
	<tr><td><label id="projectdetail">Resources:</label> <c:out value="${projectOrganization.resources}" /><br /><br /></td></tr>	
	</table>
</div>

</td>
</tr>

</table>

</div>
