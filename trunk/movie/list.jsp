<%@ taglib prefix="s" uri="/struts-tags"%>

<p>Movies</p>
<s:if test="movies.size > 0">
	<table>
		<s:iterator value="movies">
			<tr id="row_<s:property value="id"/>">
				<td>
					<s:property value="title" />
				</td>
				<td>
					<s:property value="originalTitle" />
				</td>
				<td>
					<s:url id="removeUrl" action="movie.remove">
						<s:param name="id" value="id" />
					</s:url>
					<s:a href="%{removeUrl}" theme="ajax" targets="movies">Remove</s:a>
					<s:a id="a_%{id}" theme="ajax" notifyTopics="/movie.edit">Edit</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>