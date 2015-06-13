<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authorize access="!isAuthenticated()">
<p class="introduction">
The project portal is a place where you can enter any projects that you work on
and be able to keep track of them with an interactive blog.  You can also share 
your project information with others who are interested.  This project portal site 
is a one stop shop for all of your awesome endeavors.
</p>
<p>&nbsp;</p>
<ul>
<li style="margin-bottom: 12px;">Keep track of your projects.</li>
<li style="margin-bottom: 12px;">Record key project events.</li>
<li style="margin-bottom: 12px;">Share your project ideas.</li>
</ul>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<div id="loggedinmsg">You are logged in.</div>
	<br />
	
	<h3>Your Messages</h3>
	
	<div id="usermessages">
	<c:forEach var="message" items="${userMessages}" varStatus="counter">
		<table>
		<tr>
		<td width="335px">
			<span id="usermessagelabel">User:</span> <c:out value="${message.sender}" />
			&nbsp;&nbsp;<c:out value="${message.createdDate}" /><br />
			<span id="usermessagelabel">Subject:</span> <c:out value="${message.subject}" />
		</td>
		<td width="20px">
			<button type="button" onclick="location.href='${root}/sendmessagereply?receiver=${message.sender}&subject=RE:%20${message.subject}'">Reply</button>
		</td>
		</tr>
		<tr>
		<td colspan="2" id="usermessageborder">
			<span style="font-weight: bold;">Message:</span> <c:out value="${message.message}" />
		</td>
		</tr>
		</table>
		<br />
	</c:forEach>
	</div>
</sec:authorize>
