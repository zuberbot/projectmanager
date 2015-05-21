<%-- This is the body content template --%>

<div id="contentlayoutouter">
<div id="contentlayoutinner">

<% String includePage = request.getParameter("page"); %>
<jsp:include page="<%=includePage%>"/>

</div>

<div id="contentlayoutmargin">
	<img src="${root}/static/images/treasure_chest.png" />    
</div>

</div>
