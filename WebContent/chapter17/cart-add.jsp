<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p></p>
<form action="cart-add" method="post">
商品名：<input type="text" name="name"><br>
価　格：<input type="text" name="price"><br>
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>