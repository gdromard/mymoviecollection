<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Search</title>
	<s:head />
</head>
<body>
	<h1>Search</h1>
	
	<s:form action="list" theme="xhtml">
			<s:textfield label="Search" key="search"/>
			<s:submit cssClass="btn" label="Search"></s:submit>
	</s:form>

	<br/>	
</body>
</html>