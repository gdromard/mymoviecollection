<%@page import="java.util.Enumeration"%>
<br/>
<br/>
<br/>
<script language="JavaScript">
	function toggleDebug() {
		var div = document.getElementById('debug-content');
		if (div.style.display == 'none') {
			div.style.display = 'block';
		} else {
			div.style.display = 'none';
		}
	}
</script>
<div id="debug" style="cursor: pointer; color: gray" onClick="toggleDebug()">Show debug informations
	<div id="debug-content" style="display: none; border: 1px solid black; padding: 10px; background: rgb(250, 250, 250)">
		<br/>
		DEBUG INFO<br/>
		<br/>
		request.getRemoteAddr() = <%= request.getRemoteAddr() %>
		<br/>
		<br/>
		<br/>
		Request Parameters:
		<table border=1 width=80%>
			<tr>
				<th>Parameter Name</th>
				<th>Parameter Value</th>
			</tr>
			<% for (Enumeration enu = request.getParameterNames(); enu.hasMoreElements();) {
			String key = (String) enu.nextElement();%>
				<tr>
					<td><%=key%></td>
					<td><%=request.getParameter(key)%></td>
				</tr>
			<% } %>
		</table>
		
		<br/>
		<br/>
		<br/>
		Request Attributes:
		<table border=1 width=80%>
			<tr>
				<th>Attribute Name</th>
				<th>Attribute Value</th>
			</tr>
			<% for (Enumeration enu = request.getAttributeNames(); enu.hasMoreElements();) {
			String key = (String) enu.nextElement();%>
				<tr>
					<td><%=key%></td>
					<td><%=request.getAttribute(key)%></td>
				</tr>
			<% } %>
		</table>
		
		
		<br/>
		<br/>
		<br/>
		Request Headers:
		<table border=1 width=80%>
			<tr>
				<th>Header Name</th>
				<th>Header Value</th>
			</tr>
			<% for (Enumeration enu = request.getHeaderNames(); enu.hasMoreElements();) {
			String key = (String) enu.nextElement();%>
				<tr>
					<td><%=key%></td>
					<td><%=request.getHeader(key)%></td>
				</tr>
			<% } %>
		</table>
		
		
		
		<br/>
		<br/>
		<br/>
		Cookies:
		<table border=1 width=80%>
			<tr>
				<th>Cookie Name</th>
				<th>Cookie Value</th>
			</tr>
			<% for (int i=0; i<request.getCookies().length; ++i) {%>
				<tr>
					<td><%=request.getCookies()[i].getName()%></td>
					<td><%=request.getCookies()[i].getValue()%></td>
				</tr>
			<% } %>
		</table>
<%--
		<br/>
		<br/>
		<br/>
		Session Attributes:
		<table border=1 width=80%>
			<tr>
				<th>Attribute Name</th>
				<th>Attribute Value</th>
			</tr>
			<% for (Enumeration enu = request.getSession().getAttributeNames(); enu.hasMoreElements();) {
			String key = (String) enu.nextElement();%>
				<tr>
					<td><%=key%></td>
					<td><%=request.getSession().getAttribute(key)%></td>
				</tr>
			<% } %>
		</table>
		
		
		<br/>
		<br/>
		<br/>
		Application Attributes:
		<table border=1 width=80%>
			<tr>
				<th>Attribute Name</th>
				<th>Attribute Value</th>
			</tr>
			<% for (Enumeration enu = request.getSession().getServletContext().getAttributeNames(); enu.hasMoreElements();) {
			String key = (String) enu.nextElement();%>
				<tr>
					<td><%=key%></td>
					<td><%=request.getSession().getServletContext().getAttribute(key)%></td>
				</tr>
			<% } %>
		</table>
--%>		
	</div>
</div>