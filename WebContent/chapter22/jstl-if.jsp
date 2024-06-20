<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!--  JSTL をインポート -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ Math.random() < 0.5 }">
	あたり!
</c:if>

<!-- P353 -->
<c:url var="result" value="/chapter8/greeting-out.jsp">
	<c:param name="user" value="ひぐペン工房" />
</c:url>

<a href=${ result }>URL</a>

<p> ${ result }</p>

<%@include file="../footer.html" %>








