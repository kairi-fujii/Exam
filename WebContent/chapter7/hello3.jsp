<%-- 教科書P109 LIST 07-06 --%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ（URL）になる --%>
<%@include file="../header.html" %>

<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>includeを利用しています</p>

<%-- Javaプログラムを記述 システム日付を表示 --%>
<p><% out.print(new java.util.Date()); %></p>

<%@include file="../footer.html" %>
