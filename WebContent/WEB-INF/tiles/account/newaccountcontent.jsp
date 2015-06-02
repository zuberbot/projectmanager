<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
<!--
// http://www.codingpedia.org/ama/recaptcha-and-spring-mvc-integration/
var strings = new Array();
strings['recaptcha.instructions_visual'] = "<spring:message code='recaptcha.instructions_visual' javaScriptEscape='true'/>";
strings['recaptcha.instructions_audio'] = "<spring:message code='recaptcha.instructions_audio' javaScriptEscape='true'/>"; 
strings['recaptcha.play_again'] = "<spring:message code='recaptcha.play_again' javaScriptEscape='true'/>";
strings['recaptcha.cant_hear_this'] = "<spring:message code='recaptcha.cant_hear_this' javaScriptEscape='true'/>";
strings['recaptcha.visual_challenge'] = "<spring:message code='recaptcha.visual_challenge' javaScriptEscape='true'/>";
strings['recaptcha.audio_challenge'] = "<spring:message code='recaptcha.audio_challenge' javaScriptEscape='true'/>";
strings['recaptcha.refresh_btn'] = "<spring:message code='recaptcha.refresh_btn' javaScriptEscape='true'/>"; 
strings['recaptcha.help_btn'] = "<spring:message code='recaptcha.help_btn' javaScriptEscape='true'/>";
strings['recaptcha.incorrect_try_again'] = "<spring:message code='recaptcha.incorrect_try_again' javaScriptEscape='true'/>";

var RecaptchaOptions = {
	custom_translations : {
		instructions_visual : strings['recaptcha.instructions_visual'] ,
		instructions_audio : strings['recaptcha.instructions_audio'],
		play_again : strings['recaptcha.play_again'],
		cant_hear_this : strings['recaptcha.cant_hear_this'],
		visual_challenge : strings['recaptcha.visual_challenge'],
		audio_challenge : strings['recaptcha.audio_challenge'],
		refresh_btn : strings['recaptcha.refresh_btn'],
		help_btn : strings['recaptcha.help_btn'],
		incorrect_try_again : strings['recaptcha.incorrect_try_again']
	},
	theme : 'clean'
};
//-->
</script>

<br />

<sf:form method="post" id="details" action="${root}/createaccount" commandName="user">

<table class="formtable">

<tr>
<td width="33%" class="label">User Name: </td>
<td width="67%">

<spring:bind path="userName">			
<sf:input path="userName" type="text" /><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>

</td>
</tr>

<tr>
<td width="33%" class="label">Name: </td>
<td width="67%">

<spring:bind path="name">			
<sf:input path="name" type="text" /><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>

</td>
</tr>

<tr>
<td width="33%" class="label">Email: </td>
<td width="67%">

<spring:bind path="email">			
<sf:input path="email" type="text" /><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>

</td>
</tr>

<tr>
<td width="33%" class="label">Password: </td>
<td width="67%">

<spring:bind path="password">			
<sf:input path="password" id="password" type="password" /><br />
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>

</td>
</tr>

<tr>
<td width="33%" class="label">Confirm Password: </td>
<td width="67%"><input type="password" id="confirmpass" /><br />
<div id="matchpass"></div>
</td>
</tr>

<tr>
<td colspan="2"><br />

<div id="captcha_paragraph">

<%
	// http://www.codingpedia.org/ama/recaptcha-and-spring-mvc-integration/
	// https://www.google.com/recaptcha/admin#site/318719158?setup
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
			"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", 
			"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", 
			false);
	out.print(c.createRecaptchaHtml(null, null));
%>
<br />

<spring:bind path="invalidRecaptcha">			
	<c:if test="${status.error}">
		<span class="error"><c:out value="${status.errorMessage}"/></span>
	</c:if>
</spring:bind>

</div>

</td>
</tr>

<tr>
<td colspan="2"><br /><span id="allfieldsrequired">All fields required.</span></td>
</tr>

<tr>
<td><br /><input type="submit" value="Create Account" /></td>
<td></td>
</tr>

</table>

</sf:form>
