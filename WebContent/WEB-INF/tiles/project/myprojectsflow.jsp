<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
<!--
$(document).ready(function() {
	var projects = '<c:out value="${fromProjectList.size()}" />';
	for ( var i = 0; i < projects; i++ ) {
		$('#confirmDelete' + i).click(function(e) {
		    var answer = confirm("Are you sure you want to delete this project?");
		    if (!answer){
		        e.preventDefault();
		    }
		});
	}
});
//-->
</script>

<div id="nosearchresultstitle"><h2>My Projects</h2></div>
<div id="searchresultstitle"><h2>Projects Search Results</h2></div>

<div id="searchresult"></div>
<div id="nosearchresults" class="nosearchresultsprojectflow">

${fromProjectJQuery}

<c:forEach var="project" items="${fromProjectList}" varStatus="counter">
<div id="${project.id}" class="projecttitleview">
	<table>
	<tr>
	<td width="400px">
		<a href="${flowExecutionUrl}&amp;_eventId=gotoMyProjectDetails&amp;projectid=${project.id}">
			<span id="projectnameflow"><c:out value="${project.projectName}"></c:out></span>
		</a>
	</td>
	<td width="325px">
		Last Updated: <c:out value="${project.updatedLastDate}"></c:out>
	</td>
	<td rowspan="2" width="50px">
	<a href="${root}/editproject?projectId=${project.id}">
		<img src="${root}/static/images/edit.png" title="Edit Project" />
	</a>
	<a href="${root}/deleteproject?projectId=${project.id}" id="confirmDelete${counter.index}">
		<img src="${root}/static/images/delete.png" title="Delete Project" />
	</a>	
	</td>
	</tr>

	<tr>
	<td colspan="2">
		<c:out value="${project.projectShortDescription}"></c:out>
		<br />
	</td>
	</tr>
	</table>
</div>	
<br />
</c:forEach>

</div>
