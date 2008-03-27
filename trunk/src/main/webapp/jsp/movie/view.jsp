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
	<table>
		<s:label key="movie.id" label="Movie n°"/>
		<s:label key="movie.title" label="Title"/>
		<s:label key="movie.originalTitle" label="Original Title"/>
		<s:label key="movie.size" label="Size"/>
		<s:label key="movie.year" label="Year" />
		<s:label key="movie.length" label="Length"/>
		<s:label key="movie.imageLink" label="imageLink"/>
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
		<s:label label="Synopsis" key="movie.synopsis"/>
	</table>
</body>
</html>
