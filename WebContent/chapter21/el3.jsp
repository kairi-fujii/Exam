<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- Math.random()：乱数を生成するメソッド（範囲：0～1） -->
<!-- Mathライブラリ 暗黙のライブラリ -->
${ Math.random()<0.5 ? "あたり" : "はずれ" }

<%@include file="../footer.html" %>