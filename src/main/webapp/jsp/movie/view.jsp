<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><s:property value="movie.title"/></title>
	<s:head />
</head>
<body>
	<h1><s:property value="movie.title"/></h1>
	
	<table>
		<tr>
			<td>
				<img src="<s:url value='/covers/%{movie.imageLink}'/>" width="300"/>
			</td>
			<td>
				<table>
					<s:label label="Movie n°" key="movie.id"/>
<!-- 					<s:label label="Title" key="movie.title"/>
-->
					<s:label label="Original Title" key="movie.originalTitle"/>
					<s:label label="Size" key="movie.size"/>
					<s:label label="Year" key="movie.year" />
					<s:label label="Length" key="movie.length"/>
					<s:label label="imageLink" key="movie.imageLink"/>
					<s:label label="Format" key="movie.format.name"/>
					<s:label label="Version" key="movie.version.name"/>
					<s:label label="Quality" key="movie.quality.name"/>
					<s:label label="Genre" key="movie.genre.name"/>
					<s:label label="Nationality" key="movie.nationality.name"/>
					<s:label label="Director" key="movie.director.name"/>
					<s:label label="Cast1" key="movie.cast1.name"/>
					<s:label label="Cast2" key="movie.cast2.name"/>
					<s:label label="Cast3" key="movie.cast3.name"/>
					<s:label label="Cast4" key="movie.cast4.name"/>
				</table>
			</td>
		</tr>
	</table>
	<s:property value="movie.synopsis"/>

	<br/>	
	<p class="buttons"><a class="btn" href="<s:url value='/movie/edit.action?id=%{movie.id}'/>">Edit</a></p>
	
	<center>
		<s:url id="prevUrl" action="previous"><s:param name="id" value="movie.id" /></s:url>
		<s:a cssClass="btn" href="%{prevUrl}"><s:text name="prev"/></s:a>

		<s:url id="nextUrl" action="next"><s:param name="id" value="movie.id" /></s:url>
		<s:a cssClass="btn" href="%{nextUrl}"><s:text name="next"/></s:a>
	</center>
</body>
</html>