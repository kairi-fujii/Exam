<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html" %>

<!-- 例外エラーのページ設定をする -->
<%@page errorPage="total-error.jsp" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- getParameterメソッドを使ってpostされた値を取得 -->
<%
int price = Integer.parseInt(request.getParameter("price"));
int count = Integer.parseInt(request.getParameter("count"));
%>

<%=price %>円 x <%=count %>個 = <%=price*count %>円

<%@include file="../footer.html" %>