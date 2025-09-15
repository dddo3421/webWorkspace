<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<String> dataList = new ArrayList<>();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!");
	
	request.setAttribute("dataList", dataList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach</title>
</head>
<body>
	<c:forEach var="data" items="${dataList }">
		${data }<br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i=${i }, 반복횟수 : ${loop.count }, index:${loop.index }
		 ${loop.first? '첫번째':'' }${loop.last? '마지막' :'' }<br>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i} = ${5*i}<br>
	</c:forEach>
	<hr>
	forTokens : 주어진 문자열을 구분자로 분리<br>
	<c:set var="fruits" value="사과, 파인애플, 망고, 귤, 바나나"/>
	<c:forTokens var="token" items="${fruits}" delims=",">
		${token }<br>
	</c:forTokens>
</body>
</html>