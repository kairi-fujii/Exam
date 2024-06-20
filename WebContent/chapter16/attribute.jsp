<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<!-- bean.Product をインポート -->
<%@page import="bean.Product" %>
<!--
	Product型のオブジェクトを
	request.getAttribute()メソッドを使って
	サーブレットからデータを受け取る
	（）の中はサーブレットで指定した変数名で取得
-->
<% Product p = (Product)request.getAttribute("product"); %>

<table border="1">
	<thead>
		<th>ID</th><th>Name</th><th>Price</th>
	</thead>
	<tbody>
		<tr>
			<!-- productオブジェクトの ゲッターを使って値を表示 -->
			<td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
		</tr>
	</tbody>
</table>

<%@include file="../footer.html" %>
