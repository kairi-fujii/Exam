<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- bean.Product をインポート -->
<%@page import="bean.Product" %>
<!-- List をインポート -->
<%@page import="java.util.List" %>

<!--
	Product型オブジェクトのリストを
	request.getAttribute()メソッドを使って
	サーブレットからデータを受け取る
	（）の中はサーブレットで指定した変数名で取得
-->
<% List<Product> list = (List<Product>)request.getAttribute("list"); %>

<table border="1">
	<thead>
	<th>ID</th><th>Name</th><th>Price</th>
	</thead>
	<tbody>
	<!-- ループ文を使ってリストの中身を表示 -->
	<% for (Product p : list) {%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
		</tr>
	<% } %>
	</tbody>
</table>

<%@include file="../footer.html" %>
