<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page import="java.util.*" %>

<%
	int[] array={0, 1, 2};
	request.setAttribute("array", array);

	List<String> list = new ArrayList<>();
	list.add("zero");
	list.add("one");
	list.add("two");
	request.setAttribute("list", list);

	Map<String, String> map = new HashMap<>();
	map.put("zero", "零");
	map.put("one" , "壱");
	map.put("two" , "弐");
	request.setAttribute("map", map);

%>

<table>
	<tbody>
		<td>${ array[1]   }</td><tr>
		<td>${ list[2]    }</td><tr>
		<td>${ map["one"] }</td><tr>
		<td>${ map.two    }</td><tr>
		</tr>
	</tbody>
</table>


<%@include file="../footer.html" %>