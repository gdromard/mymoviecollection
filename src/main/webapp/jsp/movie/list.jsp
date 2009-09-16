<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Movie List</title>
</head>
<body>
	<table class="grid" width="90%">
		<tr>
			<th>Id</th>
			<th>Title</th>
		</tr>
		<s:iterator value="movies" status="it">
			<s:if test="#it.index >= (page-1)*pageSize && #it.index < page*pageSize">
				<tr class="line${it.index%2}">
					<s:url id="viewUrl" action="view">
						<s:param name="id" value="id" />
					</s:url>
					<td><s:property value="id"/></td>
					<td><s:a href="%{viewUrl}"><s:property value="title"/></s:a></td>
				</tr>
			</s:if>
		</s:iterator>
	</table>
	<center>
		<s:if test="page > 1">
			<s:url id="listUrl" action="list"><s:param name="page" value="page-1" /><s:param name="pageSize" value="pageSize" /></s:url>
			<s:a cssClass="btn" href="%{listUrl}"><s:text name="prev"/></s:a>
		</s:if>
		<s:text name="%{page} / %{movies.size() / pageSize}" />
		<s:if test="page < movies.size() / pageSize">
			<s:url id="listUrl" action="list"><s:param name="page" value="page+1" /><s:param name="pageSize" value="pageSize" /></s:url>
			<s:a cssClass="btn" href="%{listUrl}"><s:text name="next"/></s:a>
		</s:if>
	</center>
</body>
</html>
	