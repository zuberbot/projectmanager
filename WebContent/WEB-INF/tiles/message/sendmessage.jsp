<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:eval var="enterSubject" expression="@ValidationMessages.getProperty('Message.subject.placeholder')" />
<spring:eval var="enterMessage" expression="@ValidationMessages.getProperty('Message.message.placeholder')" />

<div id="nosearchresultstitle"><h2>Send A Message</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>
<div id="searchresult"></div>
<div id="nosearchresults">

<script type="text/javascript">
<!--
$(document).ready(function() {
	document.sendMessageForm.subject.focus(); 

	var textMax = 140;
    $('#textareafeedback').html(textMax + ' characters remaining');

    $('#message').keyup(function() {
        var textLength = $('#message').val().length;
        var textRemaining = textMax - textLength;
        $('#textareafeedback').html(textRemaining + ' characters remaining');
    });
});
//-->
</script>

<div id="sendmessage">

<sf:form name="sendMessageForm" method="post" action="${root}/dosendmessage" commandName="userMessage">

<sf:input type="hidden" name="id" path="id" />
<sf:input type="hidden" name="sender" path="sender" value="${loggedOnUser}" />

<table>

<tr>
<td class="createmessage_tablecell">To User: </td>
<td>
<sf:input type="text" path="sendee" name="sendee" style="width: 375px;" value="${nameOfUser}" cssClass="readonlytextfield" readonly="true" />
</td>
</tr>

<tr>
<td class="createmessage_tablecell">Subject: </td>
<td>
<spring:bind path="subject">
<sf:input type="text" path="subject" name="subject" placeholder="${enterSubject}" value="${replySubject}" style="width: 375px;" />
	<c:if test="${status.error}">
		<span class="error"><br /><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
</td>
</tr>

<tr><td colspan="2">&nbsp;</td></tr>

<tr>
<td class="createmessage_tablecell" valign="top">Message: </td>
<td>
<spring:bind path="message">
<sf:textarea path="message" name="message" id="message" placeholder="${enterMessage}" cssClass="messagebox"></sf:textarea><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>
<div id="textareafeedback"></div>
</td>
</tr>

<tr><td><br /><input type="submit" value="Send" /></td></tr>

</table>
</sf:form>

</div>

</div>
