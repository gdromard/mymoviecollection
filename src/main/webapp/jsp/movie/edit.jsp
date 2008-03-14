<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>${title}</title>
	<s:head />
</head>
<body>
	<s:form action="update" theme="xhtml">
		<s:textfield label="Id"             name="movie.id" readonly="true"/>
		<s:textfield label="Title"          name="movie.title" />
		<s:textfield label="Original Title" name="movie.originalTitle" />
		<s:textfield label="Size"           name="movie.size" />
		<s:textfield label="Year"           name="movie.year" />
		<s:textfield label="Length"         name="movie.length" />
		<s:textfield label="Image Name"     name="movie.imageLink" readonly="true"/>
		<select>
			<s:iterator value="formats">
				<option value="<s:property value="id"/>"><s:property value="name"/></option>
			</s:iterator>
		</select>
		<%--
		<s:select label="Format"      name="movie.format.id"      list="%{formats}" listKey="id" listValue="name"/>
		<s:select label="Version"     name="movie.version.id"     list="%{versions}" listKey="id" listValue="name"/>
		<s:select label="Quality"     name="movie.quality.id"     list="{qualitys}" />
		<s:select label="Genre"       name="movie.genre.id"       list="{genres}" />
		<s:select label="Nationality" name="movie.nationality.id" list="{nationalitys}" />
		<s:select label="Director"    name="movie.director.id"    list="{castings}" />
		<s:select label="Casting"     name="movie.cast1.id"       list="{castings}" />
		<s:select label=" "           name="movie.cast2.id"       list="{castings}" />
		<s:select label=" "           name="movie.cast3.id"       list="{castings}" />
		<s:select label=" "           name="movie.cast4.id"       list="{castings}" />
		--%>
		<s:textarea label="Synopsis" name="movie.synopsis"/>
		<s:submit />
	</s:form>
</body>
</html>
	