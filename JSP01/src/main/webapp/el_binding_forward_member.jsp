<%@page import="sec01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="sec01.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberVO 객체 바인</title>
</head>
<body>
<%
	MemberVO mem = new MemberVO("lee", "1234", "이몽룡","lee@abc.com");
	request.setAttribute("mem", mem);
%>
	<jsp:forward page="el_binding_forward_member_result.jsp"/>
</body>
</html>