<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- フォームを使って値を入力させる -->
<!-- action：submit(ボタンを押下)されたときの実行されるプログラム -->
<!-- mrthod：リクエストの方法 post/get -->
<form action="total-out.jsp" method="post">
	<!-- プログラム側では name の値を使って参照 -->
	<input type="text" name="price">
	円x
	<input type="text" name="count">
	個=
	<input type="submit" value="計算">
</form>

<%@include file="../footer.html" %>










