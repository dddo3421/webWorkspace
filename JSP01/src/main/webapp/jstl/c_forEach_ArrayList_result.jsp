<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL : c:forEach</title>
</head>
<body>
	<table border="1" >
			<tr align="center"><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
			<c:forEach items="${memList }" var="data">
			<tr><th>${data.id }</th><th>${data.pwd }</th><th>${data.name }</th><th>${data.email }</th></tr>
			</c:forEach>
	</table>
</body>
</html>