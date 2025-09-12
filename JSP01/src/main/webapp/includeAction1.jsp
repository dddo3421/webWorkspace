<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include 액션 태그1</title>
	</head>
	<body>
		<h3>includeAction1 입니다</h3>
		<hr>
		<%--jsp action 태그 : include 이중태그/단일태그 모두 가능
			제어를 다른 페이지로 넘기게 됨(동적 데이터 구성)
		--%>
		<jsp:include page="includeAction2.jsp"/>
		
	</body>
</html>