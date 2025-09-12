<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%!
 	String name = "홍길동";
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include 지시어 : 메인</title>
	</head>
	<body>
		<!-- top -->
		이 부분에 top.jsp의 내용이 포함됩니다 <p/>
		<%@include file="top.jsp" %>
		
		<hr />
		<!-- 본문 -->
		<h3>본문</h3>
		이 부분이 jsp_include.jsp 내용입니다 <p/>
		
		<hr />
		<!--  bottom -->
		이 부분에 bottom.jsp의 내용이 포함(해당파일의 코드를 복사해서 아래 붙여넣기가 됨)됩니다 <p/>
		<%@include file="bottom.jsp" %>
	</body>
</html>