<%-- 教科書P114 LIST 07-09 --%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- JSPの宣言による変数の宣言 メンバ変数になる --%>
<%!
	int countA=0;
	int countC=100;
%>
<%
	// スクリプトレット内で定義される変数
	// JSPが実行している間だけ有効
	int countB=0;

	// インクリメント
	countA++;
	countB++;
	// デクリメント
	countC--;

	// スクリプトレット内にはJavaが記述できるので
	// if文を書くこともできます
	if(countA >= 100){
		countA=0;
	}
	if(countC <= 0 ){
		countC = 100;
	}

%>
<p>宣言による変数countAは<%=countA %></p>
<p>宣言による変数countCは<%=countC %></p>
<p>スクリプトレット内の変数countBは<%=countB %></p>


<%@include file="../footer.html" %>





