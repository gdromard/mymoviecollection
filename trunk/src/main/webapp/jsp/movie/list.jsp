<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Movie List</title>
	<s:head />
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
		</tr>
		<s:iterator value="movies" status="it">
			<tr class="line${it.index%2}">
				<td><s:property value="id"/></td>
				<td><s:property value="title"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
	