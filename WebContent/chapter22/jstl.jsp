<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!--  JSTL をインポート -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
	<thead>
	<th>ID</th><th>Name</th><th>Price</th>
	</thead>
	<tbody>
		<!-- ループ文を使ってリストの中身を表示 -->
		<c:forEach var = "p" items = "${ list }" >
			<tr>
				<!--  -->
				<td> ${ p.id   } </td>
				<td> ${ p.name } </td>
				<td> ${ p.price} </td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@include file="../footer.html" %>
