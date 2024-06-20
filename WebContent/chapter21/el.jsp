<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!--  EL式で書かれたソース  -->
<p>
  I D：${product.id}<br>
 NAME：${product.name}<br>
PRICE：${product.price}<br>
</p>

<p>
=========================================================================
</p>

<!-- 今まで通りのソース -->
<!-- bean.Product をインポート -->
<%@page import="bean.Product" %>
<% Product p = (Product)request.getAttribute("product"); %>

<p>
  I D：<%=p.getId() %><br>
 NAME：<%=p.getName() %><br>
PRICE：<%=p.getPrice() %><br>
</p>

<%@include file="../footer.html" %>