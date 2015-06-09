<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page import="com.myprojects.web.utility.MyProjectsJSPUtility" %>

<%! 
public String getLoggedOnUser() {
	return MyProjectsJSPUtility.getLoggedOnUser();
}
%>

<script type="text/javascript">
<!--
$(document).ready(function() {
	var darker = "#99ff99";
	var lighter = "#ccffcc";
	
	hoverEffect("#loginlink", darker, lighter);
	hoverEffect("#createaccountlink", darker, lighter);
	hoverEffect("#homelink", darker, lighter);
	hoverEffect("#logoutlink", darker, lighter);
	hoverEffect("#helplink", darker, lighter);
	hoverEffect("#helplinkauth", darker, lighter);
	hoverEffect("#projectslink", darker, lighter);
	hoverEffect("#createprojectlink", darker, lighter);
});

function hoverEffect(element, backgroundColor, hoverColor) {
	$(element).mouseover(function() {
    	$(element).css("background-color", backgroundColor);
	});
	$(element).mouseout(function() {
    	$(element).css("background-color", hoverColor);
	});	
}
//-->
</script>

<div class="headerwrapper">
<div class="headerlinks">

<sec:authorize access="!isAuthenticated()">
	<div id="loginlink">
		<a href="<c:url value='/login' />" id="anchorlinklogin">Log in</a>
	</div>
	<div id="createaccountlink">
		<a href="<c:url value='/newaccount' />" id="anchorlinkcreateaccount">Create Account</a>
	</div>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<div id="logoutlink">
		<a href="<c:url value='/j_spring_security_logout' />" id="anchorlinklogout">Log out</a>
	</div>
</sec:authorize>

<div id="homelink">
	<a href="<c:url value='/' />" id="anchorlinkhome">Home</a>
</div>

<sec:authorize access="!isAuthenticated()">
	<div id="helplink">
		<a href="<c:url value='/help' />" id="anchorlinkhelp">Help</a>
	</div>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<div id="projectslink">
		<a href="<c:url value='/viewmyprojects' />" id="anchorlinkprojects">My Projects</a>
	</div>
	<div id="createprojectlink">
		<a href="<c:url value='/createproject' />" id="anchorlinkcreateproject">Create Project</a>
	</div>
	<div id="helplinkauth">
		<a href="<c:url value='/help' />" id="anchorlinkhelp">Help</a>
	</div>

	<div id="headerspacer"></div>
	
	<div id="searchform">
		<sf:form method="post" id="searchForm" commandName="projectSearch">
			<%  // Issue with IE search text box not lining up correctly vertically
				String browserType = request.getHeader("User-Agent");
				if (browserType != null) {
					if (browserType.indexOf("MSIE") > -1 || browserType.indexOf("Trident") > -1) {
			%>
						<sf:input type="text" path="searchString" id="searchtextboxIE" placeholder="Search projects ..." value="" />
			<%		} else { %>
						<sf:input type="text" path="searchString" id="searchtextbox" placeholder="Search projects ..." value="" />
			<%						
					}
				}
			%>
		</sf:form>
	</div>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<div id="socialmedialinkauth">
		<jsp:include page="/WEB-INF/tiles/socialmedia.jsp"></jsp:include>
	</div>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<div id="socialmedialink">
		<jsp:include page="/WEB-INF/tiles/socialmedia.jsp"></jsp:include>
	</div>
</sec:authorize>

</div>
</div>

<script type="text/javascript">
<!--
var rootContext = "${root}";

// Attach a submit handler to the form
$("#searchForm").submit(function(event) {
	// Clear existing result first if any
	$("#searchresult").empty();

	// Get the search string value
	var text = $("#searchtextbox").val();
	
	if (typeof text === "undefined") {
		// For IE
		text = $("#searchtextboxIE").val();
	}
	
	// Stop form from submitting normally
	event.preventDefault();

	// Send the data using post
	var posting = $.ajax({
		"type" : "POST",
		"url" : "/MyProjectsSpring/dosearchprojects",
		"data" : JSON.stringify({"searchString" : "\"" + text + "\""}),
		"success" : success,
		"error" : error,
		contentType : "application/json",
	    mimeType : "application/json",
		dataType : "json",
		async : false,
		cache : false,          
		processData : false
	});

	// Put the results in a div
	posting.done(function(data) {
		var json = $.parseJSON(data.searchResults);
		// json.projects.project0.projectName

		// Top JSON reference level
		$(json).each(function(i, v1) {
			// Projects level
			$.each(v1, function(k1, v2) {
				
				// Each project level
				$.each(v2, function(k2, v3) {
					$('#searchresult').append("<hr size=\"1\">");

					// Project detail level
					var counter = 0;
					var sendMsgLink = true;
					var projectOwner = "";
					
					$.each(v3, function(k3, v4) {
						if (counter == 1 && v4 == '<%=getLoggedOnUser() %>') {
							sendMsgLink = false;
						} else if (counter == 1) {
							projectOwner = v4;
						} else {
							$('#searchresult').append(k3 + " : " + v4 + "<br />");
						}

						counter++;
					});

					var projectId = k2;
					projectId = projectId.substring(7, projectId.length);

					if (sendMsgLink) {
						var sendMsgLink = "<span style=\"background-color: #ccffff;\">";
						sendMsgLink += "<a href=\"" + rootContext + "/sendmessage?projectid=" + projectId + "\">";
						sendMsgLink += "&#171; Send project owner <b>" + projectOwner + "</b> a message. &#187;</a></span>";
						$('#searchresult').append(sendMsgLink);
					}
					
				});
				
			});
		});		
	});
});
//-->
</script>

